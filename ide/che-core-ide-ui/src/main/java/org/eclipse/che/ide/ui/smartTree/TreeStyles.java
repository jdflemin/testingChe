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
package org.eclipse.che.ide.ui.smartTree;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import org.vectomatic.dom.svg.ui.SVGResource;

/**
 * Style for the {@link Tree} widget.
 *
 * @author Vlad Zhukovskiy
 */
public interface TreeStyles extends ClientBundle {
  interface TreeStylesCSS extends CssResource {
    String noFocusOutline();

    String rootContainer();

    String nodeContainer();

    String jointContainer();

    String iconContainer();

    String presentableTextContainer();

    String infoTextContainer();

    String vcsHeadContainer();

    String descendantsContainer();

    String selected();

    String hover();

    String joint();

    String dragOver();

    String tree();

    String contentTree();

    String loading();

    String searchMatch();
  }

  @Source("TreeStyles.css")
  TreeStylesCSS treeStylesCss();

  @Source("iconCollapsed.svg")
  SVGResource iconCollapsed();

  @Source("iconExpanded.svg")
  SVGResource iconExpanded();
}
