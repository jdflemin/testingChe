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
package org.eclipse.che.ide.bootstrap;

import com.google.gwt.inject.client.AbstractGinModule;
import org.eclipse.che.ide.api.extension.ExtensionGinModule;

@ExtensionGinModule
public class BootstrapModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(IdeInitializationStrategy.class).toProvider(IdeInitializationStrategyProvider.class);
  }
}
