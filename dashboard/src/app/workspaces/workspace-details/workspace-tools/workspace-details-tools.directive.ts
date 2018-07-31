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
 * @ngdoc directive
 * @name workspaces.details.tools.directive:workspaceDetailsTools
 * @restrict E
 * @element
 *
 * @description
 * <workspace-details-tools></workspace-details-tools>` for displaying workspace tools entry.
 *
 * @author Ann Shumilova
 */
export class WorkspaceDetailsTools implements ng.IDirective {
  restrict = 'E';
  templateUrl = 'app/workspaces/workspace-details/workspace-tools/workspace-details-tools.html';

  controller = 'WorkspaceDetailsToolsController';
  controllerAs = 'workspaceDetailsToolsController';

  bindToController = true;

  scope: {
    [propName: string]: string
  };

  /**
   * Default constructor that is using resource
   */
  constructor() {
    this.scope = {
      onChange: '&',
      selectedMachine: '=',
      environmentManager: '='
    };
  }
}
