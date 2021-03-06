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
package org.eclipse.che.api.debug.shared.model;

import java.util.List;

/** @author Anatoliy Bazko */
public interface StackFrameDump {
  /** The list of fields. */
  List<? extends Field> getFields();

  /** The list of local variables. */
  List<? extends Variable> getVariables();

  /** Returns location of the frame. */
  Location getLocation();
}
