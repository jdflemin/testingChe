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
package org.eclipse.che.ide.part.editor;

/** Factory for creating instances of {@link AddEditorTabMenu} */
public interface AddEditorTabMenuFactory {

  /**
   * Creates new Add editor tab menu.
   *
   * @return editor tab menu
   */
  AddEditorTabMenu newAddEditorTabMenu();
}
