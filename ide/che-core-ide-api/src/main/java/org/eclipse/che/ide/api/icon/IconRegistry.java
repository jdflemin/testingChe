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
package org.eclipse.che.ide.api.icon;

import javax.validation.constraints.NotNull;
import org.eclipse.che.commons.annotation.Nullable;

/**
 * Client-side singleton component that provides possibility to define icons for UI in extensions.
 * On IDE start it populated by application-scope 'default' icons and 'generic' icon (e.g. Codenvy
 * logo).
 *
 * @author Vitaly Parfonov
 * @author Artem Zatsarynnyi
 */
public interface IconRegistry {

  /**
   * Register {@link Icon}. If icon with the same id previously registered, the old icon is replaced
   * by the specified icon.
   *
   * @param icon icon to be registered
   */
  void registerIcon(Icon icon);

  /**
   * Returns {@link Icon} by its id. If no such icon is registered, it returns the same named
   * 'default' icon. If it also not found, returns 'generic' icon.
   *
   * @param id icon id
   * @return registered icon or the same named "default" icon or "generic" icon
   */
  @NotNull
  Icon getIcon(String id);

  /**
   * Returns {@link Icon} by its id, or {@code null} if no icon with the specified id.
   *
   * @param id icon id
   * @return registered icon, or {@code null} if found no icon with the specified id
   */
  @Nullable
  Icon getIconIfExist(String id);

  /**
   * Returns 'generic' icon (e.g. Codenvy logo). May be useful when no icon found by its id.
   *
   * @return 'generic' icon
   */
  Icon getGenericIcon();
}
