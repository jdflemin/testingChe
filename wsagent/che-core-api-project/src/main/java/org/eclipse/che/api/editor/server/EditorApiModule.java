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
package org.eclipse.che.api.editor.server;

import com.google.inject.AbstractModule;
import org.eclipse.che.api.editor.server.impl.EditorChangesTracker;
import org.eclipse.che.api.editor.server.impl.EditorWorkingCopyManager;

public class EditorApiModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(EditorChangesTracker.class).asEagerSingleton();
    bind(EditorWorkingCopyManager.class).asEagerSingleton();
  }
}
