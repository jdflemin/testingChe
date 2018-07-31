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
package org.eclipse.che.ide.editor.orion.client.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class OrionUndoStackOverlay extends JavaScriptObject {

  protected OrionUndoStackOverlay() {}

  public final native boolean canUndo() /*-{
        return this.canUndo();
    }-*/;

  public final native boolean canRedo() /*-{
        return this.canRedo();
    }-*/;

  public final native boolean isClean() /*-{
        return this.isClean();
    }-*/;

  public final native void markClean() /*-{
        this.markClean();
    }-*/;

  public final native OrionUndoStackSizeOverlay getSize() /*-{
        return this.getSize();
    }-*/;

  public final native JsArray<OrionTextChangeOverlay> getRedoChanges() /*-{
        return this.getRedoChanges();
    }-*/;

  public final native JsArray<OrionTextChangeOverlay> getUndoChanges() /*-{
        return this.getUndoChanges();
    }-*/;

  public final native void add(OrionTextChangeOverlay change) /*-{
        this.add(change);
    }-*/;

  public final native void reset() /*-{
        this.reset();
    }-*/;

  public final native boolean undo() /*-{
        this.undo();
    }-*/;

  public final native boolean redo() /*-{
        this.redo();
    }-*/;

  public final native void startCompoundChange(JavaScriptObject owner) /*-{
        this.startCompoundChange(owner);
    }-*/;

  public final native void endCompoundChange() /*-{
        this.endCompoundChange();
    }-*/;
}
