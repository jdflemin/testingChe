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
package org.eclipse.che.ide.ext.java.client.refactoring.rename.wizard.similarnames;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.che.ide.ext.java.client.refactoring.rename.wizard.similarnames.SimilarNamesConfigurationView.ActionDelegate;
import org.eclipse.che.ide.ext.java.shared.dto.refactoring.RenameSettings.MachStrategy;

/**
 * The class that manages similar name value.
 *
 * @author Valeriy Svydenko
 */
@Singleton
public class SimilarNamesConfigurationPresenter implements ActionDelegate {
  private final SimilarNamesConfigurationView view;

  @Inject
  public SimilarNamesConfigurationPresenter(SimilarNamesConfigurationView view) {
    this.view = view;
    this.view.setDelegate(this);
  }

  /** Show Move panel with the special information. */
  public void show() {
    view.showDialog();
  }

  /** @return selected value of mach strategy. */
  public MachStrategy getMachStrategy() {
    return view.getMachStrategy();
  }
}
