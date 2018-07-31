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
package org.eclipse.che.ide.api.constraints;

/**
 * Defines possible directions of an item relative to another item.
 *
 * @author Roman Nikitenko
 */
public enum Direction {

  /** Direction type that specifies the item to be the horizontally at the moment of addition. */
  HORIZONTALLY,

  /** Direction type that specifies the item to be the vertically at the moment of addition. */
  VERTICALLY
}
