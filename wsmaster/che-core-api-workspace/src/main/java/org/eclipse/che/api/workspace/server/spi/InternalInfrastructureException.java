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
package org.eclipse.che.api.workspace.server.spi;

/**
 * Thrown by {@link RuntimeInfrastructure} and related components when unexpected internal error
 * occurs.
 *
 * @author Yevhenii Voevodin
 */
public class InternalInfrastructureException extends InfrastructureException {

  public InternalInfrastructureException(String message) {
    super(message);
  }

  public InternalInfrastructureException(String message, Throwable cause) {
    super(message, cause);
  }

  public InternalInfrastructureException(Exception e) {
    super(e);
  }
}
