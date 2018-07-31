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
package org.eclipse.che.api.project.shared.dto.event;

import com.google.common.annotations.Beta;
import org.eclipse.che.dto.shared.DTO;

/**
 * To transfer modified POM path
 *
 * @author Dmitry Kuleshov
 * @since 4.5
 */
@Beta
@DTO
public interface PomModifiedEventDto {
  String getPath();

  PomModifiedEventDto withPath(String path);
}
