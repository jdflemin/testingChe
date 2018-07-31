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
package org.eclipse.che.ide.api.command;

import java.util.List;

/**
 * Used for registering new command type and providing all the necessary information and components
 * for working with the appropriate command.
 *
 * <p>Implementations of this interface have to be registered using a multibinder in order to be
 * picked-up on application's start-up.
 *
 * @author Artem Zatsarynnyi
 */
public interface CommandType {

  /** Returns unique identifier for this command type. */
  String getId();

  /** Returns the display name of the command type. */
  String getDisplayName();

  /** Returns a short description what command of concrete type can do. */
  String getDescription();

  /** Returns the {@link CommandPage}s for editing command. */
  List<CommandPage> getPages();

  /**
   * Returns the command line that should be used for the newly created command when user creates it
   * from the 'Commands' dialog.
   */
  String getCommandLineTemplate();

  /** Returns template for preview Url. */
  String getPreviewUrlTemplate();
}
