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
package org.eclipse.che.maven.data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import org.eclipse.che.maven.util.JdomUtil;
import org.jdom.Element;

/**
 * Data class for org.apache.maven.model.PluginExecution
 *
 * @author Evgen Vidolob
 */
public class MavenPluginExecution implements Serializable {
  private static final long serialVersionUID = 1L;

  private final String executionId;
  private final Element configuration;
  private final List<String> goals;

  public MavenPluginExecution(String executionId, Element configuration, List<String> goals) {
    this.executionId = executionId;
    this.configuration = configuration;
    this.goals = goals;
  }

  public String getExecutionId() {
    return executionId;
  }

  public Element getConfiguration() {
    return configuration;
  }

  public List<String> getGoals() {
    return goals;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MavenPluginExecution that = (MavenPluginExecution) o;
    return Objects.equals(executionId, that.executionId)
        && JdomUtil.isElementEquals(configuration, that.configuration)
        && Objects.equals(goals, that.goals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(executionId, goals);
  }
}
