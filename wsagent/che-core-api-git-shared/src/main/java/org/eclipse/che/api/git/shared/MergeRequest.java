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
 * Request to merge {@link #commit} with HEAD.
 *
 * @author andrew00x
 */
@DTO
public interface MergeRequest {
  /** @return commit to merge */
  String getCommit();

  void setCommit(String commit);

  MergeRequest withCommit(String commit);
}
