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
package org.eclipse.che.ide.factory.action;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collections;
import javax.validation.constraints.NotNull;
import org.eclipse.che.ide.CoreLocalizationConstant;
import org.eclipse.che.ide.api.action.AbstractPerspectiveAction;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.factory.configure.CreateFactoryPresenter;

/** @author Anton Korneta */
@Singleton
public class CreateFactoryAction extends AbstractPerspectiveAction {

  private final CreateFactoryPresenter presenter;

  @Inject
  public CreateFactoryAction(
      CreateFactoryPresenter presenter, CoreLocalizationConstant localizationConstant) {
    super(
        Collections.singletonList("Project Perspective"),
        localizationConstant.createFactoryActionTitle());
    this.presenter = presenter;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    presenter.showDialog();
  }

  @Override
  public void updateInPerspective(@NotNull ActionEvent event) {}
}
