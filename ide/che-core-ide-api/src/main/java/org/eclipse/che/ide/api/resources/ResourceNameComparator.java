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
package org.eclipse.che.ide.api.resources;

import com.google.common.annotations.Beta;
import java.util.Comparator;

/**
 * Compares two {@link Resource} by their name ignoring case.
 *
 * @author Vlad Zhukovskiy
 * @see Resource#getName()
 * @since 4.4.0
 */
@Beta
public class ResourceNameComparator implements Comparator<Resource> {

  private static final ResourceNameComparator INSTANCE = new ResourceNameComparator();

  private ResourceNameComparator() {}

  public static Comparator<Resource> getInstance() {
    return INSTANCE;
  }

  /** {@inheritDoc} */
  @Override
  public int compare(Resource o1, Resource o2) {
    return o1.getName().compareToIgnoreCase(o2.getName());
  }
}
