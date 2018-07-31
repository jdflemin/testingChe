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
package org.eclipse.che.api.workspace.server.token;

import org.eclipse.che.commons.env.EnvironmentContext;
import org.eclipse.che.commons.subject.Subject;

/**
 * Provides machine token that should be used for accessing workspace master from a machine.
 *
 * @author Sergii Leshchenko
 */
public interface MachineTokenProvider {

  /**
   * Returns the machine's token for the specified workspace and user from {@link
   * EnvironmentContext#getSubject()}.
   *
   * @param workspaceId identifier of workspace to fetch token
   * @throws MachineTokenException when any exception occurs on token fetching
   * @throws IllegalStateException when subject in context is {@link Subject#ANONYMOUS}
   */
  String getToken(String workspaceId) throws MachineTokenException;

  /**
   * Returns the machine's token for the specified pair: user, workspace.
   *
   * @param workspaceId identifier of workspace to fetch token
   * @throws MachineTokenException when any exception occurs on token fetching
   */
  String getToken(String userId, String workspaceId) throws MachineTokenException;

  /** Returns empty string as machine token. */
  class EmptyMachineTokenProvider implements MachineTokenProvider {

    @Override
    public String getToken(String workspaceId) {
      return "";
    }

    @Override
    public String getToken(String userId, String workspaceId) {
      return "";
    }
  }
}
