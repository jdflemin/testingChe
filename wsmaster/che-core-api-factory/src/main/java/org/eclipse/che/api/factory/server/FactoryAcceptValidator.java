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
package org.eclipse.che.api.factory.server;

import org.eclipse.che.api.core.BadRequestException;
import org.eclipse.che.api.factory.shared.dto.FactoryDto;

/** Interface for validations of factory urls on accept stage. */
public interface FactoryAcceptValidator {

  /**
   * Validates factory object on accept stage. Implementation should throw {@link
   * BadRequestException} if factory object is invalid.
   *
   * @param factory factory object to validate
   * @throws BadRequestException in case if factory is not valid
   */
  void validateOnAccept(FactoryDto factory) throws BadRequestException;
}
