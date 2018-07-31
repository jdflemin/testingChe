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
 * Info received from pull response
 *
 * @author Igor Vinokur
 */
@DTO
public interface PullResponse {

  /** set output message */
  void setCommandOutput(String commandOutput);

  /** @return output message */
  String getCommandOutput();

  PullResponse withCommandOutput(String commandOutput);
}
