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
package org.eclipse.che.plugin.golang.projecttype;

import static org.eclipse.che.plugin.golang.shared.Constants.GOLANG_PROJECT_TYPE_ID;
import static org.eclipse.che.plugin.golang.shared.Constants.LANGUAGE;

import org.eclipse.che.api.project.server.type.ProjectTypeDef;

/** @author Eugene Ivantsov */
public class GolangProjectType extends ProjectTypeDef {

  public GolangProjectType() {
    super(GOLANG_PROJECT_TYPE_ID, "Golang", true, false, true);
    addConstantDefinition(LANGUAGE, LANGUAGE, GOLANG_PROJECT_TYPE_ID);
  }
}
