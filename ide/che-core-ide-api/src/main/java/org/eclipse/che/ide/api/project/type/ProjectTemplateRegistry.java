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
package org.eclipse.che.ide.api.project.type;

import java.util.List;
import org.eclipse.che.api.project.templates.shared.dto.ProjectTemplateDescriptor;

/** Registry of project templates. */
public interface ProjectTemplateRegistry {

  /** Get project templates for the specified {@code projectTypeId} or empty list if none. */
  List<ProjectTemplateDescriptor> getTemplates(String projectTypeId);
}
