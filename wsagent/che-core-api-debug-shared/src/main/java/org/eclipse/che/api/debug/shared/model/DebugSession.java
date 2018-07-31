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

/**
 * Debug session.
 *
 * @author Anatoliy Bazko
 */
public interface DebugSession {
  /** The info about debugger is being used. */
  DebuggerInfo getDebuggerInfo();

  /** Session id. */
  String getId();

  /** Debugger type. */
  String getType();

  /** Returns active breakpoints. */
  List<? extends Breakpoint> getBreakpoints();
}
