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
package org.eclipse.che.multiuser.resource.api.workspace;

/**
 * Defines error codes, defined codes MUST NOT conflict with existing {@link
 * org.eclipse.che.api.core.ErrorCodes}, error codes must be in range <b>10000-14999</b> inclusive.
 *
 * @author Yevhenii Voevodin
 */
public final class ErrorCodes {

  public static final int LIMIT_EXCEEDED = 10000;

  private ErrorCodes() {}
}
