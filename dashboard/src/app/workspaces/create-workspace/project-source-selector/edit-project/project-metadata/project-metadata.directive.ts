/*
 * Copyright (c) 2015-2018 Red Hat, Inc.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which is available at http://www.eclipse.org/legal/epl-2.0.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
'use strict';

/**
 * Defines a directive for the project's metadata.
 *
 * @author Oleksii Kurinnyi
 */
export class ProjectMetadata implements ng.IDirective {
  restrict: string = 'E';
  templateUrl: string = 'app/workspaces/create-workspace/project-source-selector/edit-project/project-metadata/project-metadata.html';
  replace: boolean = true;

  controller: string = 'ProjectMetadataController';
  controllerAs: string = 'projectMetadataController';

  bindToController: boolean = true;

  scope: {
    [propName: string]: string;
  };

  /**
   * Default constructor that is using resource
   */
  constructor() {
    this.scope = {
      origTemplate: '=template',
      templateName: '@',
      isProjectNameUnique: '&',
      projectForm: '='
    };
  }

}
