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
package org.eclipse.che.ide.api.editor.texteditor;

import org.eclipse.che.ide.api.editor.keymap.KeyBinding;

/** Interface for components that handles key bindings. */
public interface HasKeyBindings {

  /**
   * Adds a key bindings.
   *
   * @param keyBinding the new binding
   */
  void addKeyBinding(KeyBinding keyBinding);

  /**
   * Adds a key bindings.
   *
   * @param keyBinding the new binding
   * @param actionDescription action description
   */
  void addKeyBinding(KeyBinding keyBinding, String actionDescription);
}
