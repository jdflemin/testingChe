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
package org.eclipse.che.api.editor.server.impl;

import javax.inject.Inject;
import javax.inject.Singleton;
import org.eclipse.che.api.core.jsonrpc.commons.RequestHandlerConfigurator;
import org.eclipse.che.api.project.shared.dto.EditorChangesDto;

/**
 * Receives notifications about editor changes from client side.
 *
 * @author Roman Nikitenko
 */
@Singleton
public class EditorChangesTracker {
  private static final String INCOMING_METHOD = "track:editor-content-changes";

  private EditorWorkingCopyManager editorWorkingCopyManager;

  @Inject
  public EditorChangesTracker(EditorWorkingCopyManager editorWorkingCopyManager) {
    this.editorWorkingCopyManager = editorWorkingCopyManager;
  }

  @Inject
  public void configureHandler(RequestHandlerConfigurator configurator) {
    configurator
        .newConfiguration()
        .methodName(INCOMING_METHOD)
        .paramsAsDto(EditorChangesDto.class)
        .resultAsBoolean()
        .withBiFunction(
            (endpointId, changes) -> {
              editorWorkingCopyManager.onEditorContentUpdated(endpointId, changes);
              return true;
            });
  }
}
