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
package org.eclipse.che.api.core.model.workspace.runtime;

import java.util.Map;

/**
 * Server Runtime exposed by URL
 *
 * @author gazarenkov
 */
public interface Server {

  /** @return URL exposing the server */
  String getUrl();

  /** @return the status */
  ServerStatus getStatus();

  /** Returns attributes of the server with some metadata */
  Map<String, String> getAttributes();
}
