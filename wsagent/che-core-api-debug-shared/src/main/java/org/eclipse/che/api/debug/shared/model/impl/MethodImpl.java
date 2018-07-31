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
package org.eclipse.che.api.debug.shared.model.impl;

import java.util.List;
import java.util.Objects;
import org.eclipse.che.api.debug.shared.model.Method;
import org.eclipse.che.api.debug.shared.model.Variable;

/** @author Anatolii Bazko */
public class MethodImpl implements Method {
  private final String name;
  private final List<? extends Variable> arguments;

  public MethodImpl(String name, List<? extends Variable> arguments) {
    this.name = name;
    this.arguments = arguments;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<? extends Variable> getArguments() {
    return arguments;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof MethodImpl)) {
      return false;
    }
    final MethodImpl that = (MethodImpl) obj;
    return Objects.equals(name, that.name) && getArguments().equals(that.getArguments());
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 31 * hash + Objects.hashCode(name);
    hash = 31 * hash + getArguments().hashCode();
    return hash;
  }

  @Override
  public String toString() {
    return "MethodImpl{" + "name='" + name + '\'' + ", arguments=" + arguments + '}';
  }
}
