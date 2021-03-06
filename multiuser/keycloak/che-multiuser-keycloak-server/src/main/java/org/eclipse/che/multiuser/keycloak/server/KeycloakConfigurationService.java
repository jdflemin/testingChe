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
package org.eclipse.che.multiuser.keycloak.server;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.eclipse.che.api.core.rest.Service;

/**
 * Endpoint which provides keycloak public client authentication information (such as URL, realm,
 * client_id).
 *
 * @author Max Shaposhnik (mshaposh@redhat.com)
 */
@Singleton
@Path("/keycloak")
public class KeycloakConfigurationService extends Service {

  private final KeycloakSettings keycloakSettings;

  @Inject
  public KeycloakConfigurationService(KeycloakSettings keycloakSettings) {
    this.keycloakSettings = keycloakSettings;
  }

  @GET
  @Path("/settings")
  @Produces(APPLICATION_JSON)
  public Map<String, String> settings() {
    return keycloakSettings.get();
  }

  @GET
  @Path("/OIDCKeycloak.js")
  @Produces("text/javascript")
  public String javascriptAdapter() throws IOException {
    URL resource =
        Thread.currentThread().getContextClassLoader().getResource("keycloak/OIDCKeycloak.js");
    if (resource != null) {
      URLConnection conn = resource.openConnection();
      try (InputStream is = conn.getInputStream();
          ByteArrayOutputStream os = new ByteArrayOutputStream()) {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) != -1) {
          os.write(buffer, 0, length);
        }
        return os.toString("UTF-8");
      }
    }
    return "";
  }
}
