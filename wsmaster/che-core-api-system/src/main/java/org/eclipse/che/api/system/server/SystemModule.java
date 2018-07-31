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
package org.eclipse.che.api.system.server;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/** @author Anton Korneta */
public class SystemModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(org.eclipse.che.api.system.server.SystemService.class);
    bind(org.eclipse.che.api.system.server.SystemEventsWebsocketBroadcaster.class)
        .asEagerSingleton();
    Multibinder.newSetBinder(binder(), ServiceTermination.class);
  }
}
