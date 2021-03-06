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
package org.eclipse.che.plugin.web.client.typescript;

import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.che.ide.api.project.MutableProjectConfig;
import org.eclipse.che.ide.api.project.type.wizard.ProjectWizardRegistrar;
import org.eclipse.che.ide.api.wizard.WizardPage;
import org.eclipse.che.plugin.web.shared.Constants;

/** Provides information for registering TypeScript project type into project wizard. */
public class TSProjectWizardRegistrar implements ProjectWizardRegistrar {

  private final List<Provider<? extends WizardPage<MutableProjectConfig>>> wizardPages;

  public TSProjectWizardRegistrar() {
    wizardPages = new ArrayList<>();
  }

  @Override
  public String getProjectTypeId() {
    return Constants.TS_PROJECT_TYPE_ID;
  }

  @Override
  public String getCategory() {
    return "TypeScript";
  }

  @Override
  public List<Provider<? extends WizardPage<MutableProjectConfig>>> getWizardPages() {
    return wizardPages;
  }
}
