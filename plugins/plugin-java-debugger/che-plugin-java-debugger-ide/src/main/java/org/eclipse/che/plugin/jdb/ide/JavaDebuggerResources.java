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
package org.eclipse.che.plugin.jdb.ide;

import com.google.gwt.resources.client.ClientBundle;
import org.vectomatic.dom.svg.ui.SVGResource;

/** @author Artem Zatsarynnyi */
public interface JavaDebuggerResources extends ClientBundle {

  /** Returns the icon for Java debug configuration type. */
  @Source("configuration/java-debug-configuration-type.svg")
  SVGResource javaDebugConfigurationType();
}
