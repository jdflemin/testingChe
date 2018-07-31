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
package org.eclipse.che.ide.api.editor.events;

import com.google.gwt.event.shared.GwtEvent;
import javax.validation.constraints.NotNull;
import org.eclipse.che.ide.api.editor.changeintercept.TextChange;

/** An event describing a change in the text of an editor. */
public class TextChangeEvent extends GwtEvent<TextChangeHandler> {

  /** The type instance for this event. */
  public static final Type<TextChangeHandler> TYPE = new Type<>();

  /** The text change. */
  private final TextChange change;

  /** The updater. */
  private final ChangeUpdater updater;

  public TextChangeEvent(@NotNull final TextChange change, @NotNull final ChangeUpdater updater) {
    this.change = change;
    this.updater = updater;
  }

  @Override
  public Type<TextChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(final TextChangeHandler handler) {
    handler.onTextChange(this);
  }

  public TextChange getChange() {
    return this.change;
  }

  public void update(final TextChange updatedChange) {
    this.updater.update(updatedChange);
  }

  @Override
  public String toString() {
    return "TextChangeEvent [change=" + change + "]";
  }

  /** Action to update the change event. */
  public interface ChangeUpdater {
    void update(TextChange updatedChange);
  }
}
