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
package org.eclipse.che.api.git.shared;

import org.eclipse.che.dto.shared.DTO;

/**
 * Git file in index. Used for work with index (remove, reset).
 *
 * @author Ann Zhuleva
 */
@DTO
public interface IndexFile {
  /** @return the indexed if <code>true</code> file is in index */
  boolean isIndexed();

  void setIndexed(boolean indexed);

  IndexFile withIndexed(boolean indexed);

  /** @return file path */
  String getPath();

  void setPath(String path);

  IndexFile withPath(String path);
}
