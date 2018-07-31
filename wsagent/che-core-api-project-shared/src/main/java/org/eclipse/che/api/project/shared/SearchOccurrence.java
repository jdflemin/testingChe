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
package org.eclipse.che.api.project.shared;

/**
 * Contain information about occurrence of found phrase like: - start and send offsets in the file
 * for found phrase; - number and content of line where given phrase found; - found phrase itself;
 *
 * @author Vitalii Parfonov
 */
public interface SearchOccurrence {
  /** @return */
  float getScore();

  /** @param score */
  void setScore(float score);

  /**
   * Found phrase (eg if you try to find 'hel' and text contain 'hello', in this case phrase will be
   * 'hello')
   *
   * @return
   */
  String getPhrase();

  /** @param phrase */
  void setPhrase(String phrase);

  /**
   * End offset in file of found phrase
   *
   * @return
   */
  int getEndOffset();

  /** @param endOffset */
  void setEndOffset(int endOffset);

  /**
   * Begin offset in file of found phrase
   *
   * @return
   */
  int getStartOffset();

  /** @param startOffset */
  void setStartOffset(int startOffset);

  /**
   * Number of line where phrase found
   *
   * @param lineNumber
   */
  void setLineNumber(int lineNumber);

  /**
   * Number of line where phrase found
   *
   * @return
   */
  int getLineNumber();

  /**
   * Content of the line where phrase found
   *
   * @param lineContent
   */
  void setLineContent(String lineContent);

  /**
   * Content of the line where phrase found
   *
   * @return
   */
  String getLineContent();
}
