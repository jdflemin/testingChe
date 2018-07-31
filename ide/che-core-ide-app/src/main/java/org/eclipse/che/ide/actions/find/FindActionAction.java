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
package org.eclipse.che.ide.actions.find;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import javax.validation.constraints.NotNull;
import org.eclipse.che.ide.CoreLocalizationConstant;
import org.eclipse.che.ide.Resources;
import org.eclipse.che.ide.api.action.AbstractPerspectiveAction;
import org.eclipse.che.ide.api.action.ActionEvent;

/**
 * Action fo find action action
 *
 * @author Evgen Vidolob
 */
@Singleton
public class FindActionAction extends AbstractPerspectiveAction {

  private FindActionPresenter presenter;

  @Inject
  public FindActionAction(
      FindActionPresenter presenter, CoreLocalizationConstant localization, Resources resources) {
    super(
        null,
        localization.actionFindActionDescription(),
        localization.actionFindActionTitle(),
        resources.findActions());
    this.presenter = presenter;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    presenter.show();
  }

  @Override
  public void updateInPerspective(@NotNull ActionEvent event) {
    event.getPresentation().setEnabledAndVisible(true);
  }
}
