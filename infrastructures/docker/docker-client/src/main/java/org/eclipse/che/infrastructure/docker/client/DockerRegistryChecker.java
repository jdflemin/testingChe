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
package org.eclipse.che.infrastructure.docker.client;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import org.eclipse.che.commons.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Checks that docker registry is available.
 *
 * @author Yevhenii Voevodin
 * @author Alexander Andrienko
 */
@Singleton
public class DockerRegistryChecker {

  private static final Logger LOG = LoggerFactory.getLogger(DockerRegistryChecker.class);

  @Inject
  @Nullable
  @Named("che.docker.registry")
  private String machineDockerRegistry;

  /** Checks that registry is available and if it is not - logs warning message. */
  @PostConstruct
  private void checkRegistryIsAvailable() throws IOException {
    if (!isNullOrEmpty(machineDockerRegistry)) {
      String registryUrl = "http://" + machineDockerRegistry;

      LOG.info("Probing registry '{}'", registryUrl);
      final HttpURLConnection conn = (HttpURLConnection) new URL(registryUrl).openConnection();
      conn.setConnectTimeout(30 * 1000);
      try {
        final int responseCode = conn.getResponseCode();
        LOG.info(
            "Probe of registry '{}' succeed with HTTP response code '{}'",
            registryUrl,
            responseCode);
      } catch (IOException ioEx) {
        LOG.warn(
            "Docker registry {} is not available, "
                + "which means that you won't be able to save snapshots of your workspaces."
                + "\nHow to configure registry?"
                + "\n\tLocal registry  -> https://docs.docker.com/registry/"
                + "\n\tRemote registry -> set up 'che.docker.registry.auth.*' properties",
            registryUrl);
      } finally {
        conn.disconnect();
      }
    }
  }
}
