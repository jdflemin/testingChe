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
package org.eclipse.che.ide.devmode;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.eclipse.che.ide.CoreLocalizationConstant;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/** Tests for the {@link DevModeSetUpAction}. */
@RunWith(MockitoJUnitRunner.class)
public class DevModeSetUpActionTest {

  @Mock CoreLocalizationConstant messages;
  @Mock GWTDevMode gwtDevMode;

  @InjectMocks DevModeSetUpAction action;

  @Test
  public void shouldSetUpDevModeOnPerformingAction() throws Exception {
    action.actionPerformed(mock(ActionEvent.class));

    verify(gwtDevMode).setUp();
  }
}
