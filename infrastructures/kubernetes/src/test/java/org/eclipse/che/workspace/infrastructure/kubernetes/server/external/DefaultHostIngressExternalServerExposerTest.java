/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which is available at http://www.eclipse.org/legal/epl-2.0.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.workspace.infrastructure.kubernetes.server.external;

import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonMap;
import static org.eclipse.che.workspace.infrastructure.kubernetes.server.KubernetesServerExposer.SERVER_PREFIX;
import static org.testng.Assert.assertEquals;

import com.google.common.collect.ImmutableMap;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.ServicePort;
import io.fabric8.kubernetes.api.model.ServicePortBuilder;
import io.fabric8.kubernetes.api.model.extensions.Ingress;
import io.fabric8.kubernetes.api.model.extensions.IngressBackend;
import io.fabric8.kubernetes.api.model.extensions.IngressRule;
import java.util.Map;
import org.eclipse.che.api.core.model.workspace.config.ServerConfig;
import org.eclipse.che.api.workspace.server.model.impl.ServerConfigImpl;
import org.eclipse.che.workspace.infrastructure.kubernetes.Annotations;
import org.eclipse.che.workspace.infrastructure.kubernetes.environment.KubernetesEnvironment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/** @author Guy Daich */
public class DefaultHostIngressExternalServerExposerTest {

  private static final Map<String, String> ATTRIBUTES_MAP = singletonMap("key", "value");
  private static final String MACHINE_NAME = "pod/main";
  private static final String SERVICE_NAME = SERVER_PREFIX + "12345678" + "-" + MACHINE_NAME;

  private DefaultHostIngressExternalServerExposer externalServerExposer;
  private KubernetesEnvironment kubernetesEnvironment;

  @BeforeMethod
  public void setUp() throws Exception {
    Container container = new ContainerBuilder().withName("main").build();
    Pod pod =
        new PodBuilder()
            .withNewMetadata()
            .withName("pod")
            .endMetadata()
            .withNewSpec()
            .withContainers(container)
            .endSpec()
            .build();

    kubernetesEnvironment =
        KubernetesEnvironment.builder().setPods(ImmutableMap.of("pod", pod)).build();
    externalServerExposer = new DefaultHostIngressExternalServerExposer(emptyMap());
  }

  @Test
  public void shouldCreateIngressForServer() {
    // given
    ServerConfigImpl httpServerConfig =
        new ServerConfigImpl("8080/tcp", "http", "/api", ATTRIBUTES_MAP);
    ServicePort servicePort =
        new ServicePortBuilder()
            .withName("server-8080")
            .withPort(8080)
            .withProtocol("TCP")
            .withTargetPort(new IntOrString(8080))
            .build();
    Map<String, ServerConfig> serversToExpose = ImmutableMap.of("http-server", httpServerConfig);

    // when
    externalServerExposer.expose(
        kubernetesEnvironment, MACHINE_NAME, SERVICE_NAME, servicePort, serversToExpose);

    // then
    assertThatExternalServerIsExposed(
        MACHINE_NAME,
        SERVICE_NAME,
        "http-server",
        8080,
        servicePort,
        new ServerConfigImpl(httpServerConfig).withAttributes(ATTRIBUTES_MAP));
  }

  @Test
  public void shouldCreateIngressForServerWhenTwoServersHasTheSamePort() {
    // given
    ServerConfigImpl httpServerConfig =
        new ServerConfigImpl("8080/tcp", "http", "/api", ATTRIBUTES_MAP);
    ServerConfigImpl wsServerConfig =
        new ServerConfigImpl("8080/tcp", "ws", "/connect", ATTRIBUTES_MAP);
    ServicePort servicePort =
        new ServicePortBuilder()
            .withName("server-8080")
            .withPort(8080)
            .withProtocol("TCP")
            .withTargetPort(new IntOrString(8080))
            .build();

    Map<String, ServerConfig> serversToExpose =
        ImmutableMap.of(
            "http-server", httpServerConfig,
            "ws-server", wsServerConfig);

    // when
    externalServerExposer.expose(
        kubernetesEnvironment, MACHINE_NAME, SERVICE_NAME, servicePort, serversToExpose);

    // then
    assertEquals(kubernetesEnvironment.getIngresses().size(), 1);
    assertThatExternalServerIsExposed(
        MACHINE_NAME,
        SERVICE_NAME,
        "http-server",
        8080,
        servicePort,
        new ServerConfigImpl(httpServerConfig).withAttributes(ATTRIBUTES_MAP));
    assertThatExternalServerIsExposed(
        MACHINE_NAME,
        SERVICE_NAME,
        "ws-server",
        8080,
        servicePort,
        new ServerConfigImpl(wsServerConfig).withAttributes(ATTRIBUTES_MAP));
  }

  @SuppressWarnings("SameParameterValue")
  private void assertThatExternalServerIsExposed(
      String machineName,
      String serviceName,
      String serverNameRegex,
      Integer port,
      ServicePort servicePort,
      ServerConfigImpl expected) {

    // ensure that required ingress is created
    Ingress ingress = kubernetesEnvironment.getIngresses().get(serviceName + "-server-" + port);
    IngressRule ingressRule = ingress.getSpec().getRules().get(0);
    IngressBackend backend = ingressRule.getHttp().getPaths().get(0).getBackend();
    assertEquals(backend.getServiceName(), serviceName);
    assertEquals(backend.getServicePort().getStrVal(), servicePort.getName());

    Annotations.Deserializer ingressAnnotations =
        Annotations.newDeserializer(ingress.getMetadata().getAnnotations());
    Map<String, ServerConfigImpl> servers = ingressAnnotations.servers();
    ServerConfig serverConfig = servers.get(serverNameRegex);
    assertEquals(serverConfig, expected);

    assertEquals(ingressAnnotations.machineName(), machineName);
  }
}
