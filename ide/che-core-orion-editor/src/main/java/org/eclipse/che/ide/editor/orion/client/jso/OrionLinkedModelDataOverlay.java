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
import com.google.gwt.core.client.JsArrayString;
import java.util.List;
import org.eclipse.che.ide.api.editor.link.LinkedModelData;

/** @author Evgen Vidolob */
public class OrionLinkedModelDataOverlay extends JavaScriptObject implements LinkedModelData {
  protected OrionLinkedModelDataOverlay() {}

  @Override
  public final native void setType(String type) /*-{
        this.type = type;
    }-*/;

  @Override
  public final void setValues(List<String> values) {
    JsArrayString arr = JavaScriptObject.createArray().cast();
    for (String value : values) {
      arr.push(value);
    }
    setValues(arr);
  }

  public final native void setValues(JsArrayString val) /*-{
        this.values = val;
    }-*/;

  public static native OrionLinkedModelDataOverlay create() /*-{
        return {};
    }-*/;
}
