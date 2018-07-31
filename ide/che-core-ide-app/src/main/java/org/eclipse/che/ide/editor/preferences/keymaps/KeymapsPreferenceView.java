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
package org.eclipse.che.ide.editor.preferences.keymaps;

import java.util.List;
import org.eclipse.che.ide.api.editor.keymap.Keymap;
import org.eclipse.che.ide.api.mvp.View;

/** View interface for the preference page for the editor keymap selection. */
public interface KeymapsPreferenceView extends View<KeymapsPreferenceView.ActionDelegate> {

  void setKeyBindings(List<Keymap> availableKeyBindings, Keymap currentKeyBinding);

  /** Action delegate for the keymap preference view. */
  interface ActionDelegate {

    /**
     * Action triggered when an keymap is selected.
     *
     * @param keymap the new keymap
     */
    void onKeyBindingSelected(Keymap keymap);
  }
}
