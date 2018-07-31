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
package org.eclipse.che.plugin.languageserver.ide.editor.codeassist.snippet;

/**
 * Visitor pattern implementation for snippets.
 *
 * @author Thomas Mäder
 */
public interface ExpressionVisitor {
  void visit(DollarExpression e);

  void visit(Choice e);

  void visit(Placeholder e);

  void visit(Snippet e);

  void visit(Text e);

  void visit(Variable e);
}
