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
package org.eclipse.che.commons.json;

import java.io.Writer;
import org.everrest.core.impl.provider.json.JsonException;
import org.everrest.core.impl.provider.json.JsonWriter;

public class NameConventionJsonWriter extends JsonWriter {
  private final JsonNameConvention nameConvention;

  public NameConventionJsonWriter(Writer writer, JsonNameConvention nameConvention) {
    super(writer);
    this.nameConvention = nameConvention;
  }

  @Override
  public void writeKey(String key) throws JsonException {
    super.writeKey(nameConvention.toJsonName(key));
  }
}
