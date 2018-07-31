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
package org.eclipse.che.ide.ui.zeroclipboard;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import org.vectomatic.dom.svg.ui.SVGResource;

/** @author Oleksii Orel */
public interface ClipboardResources extends ClientBundle {
  interface Css extends CssResource {
    String clipboardButton();
  }

  @Source({"Clipboard.css", "org/eclipse/che/ide/api/ui/style.css"})
  Css clipboardCss();

  @Source("clipboard.svg")
  SVGResource clipboard();
}
