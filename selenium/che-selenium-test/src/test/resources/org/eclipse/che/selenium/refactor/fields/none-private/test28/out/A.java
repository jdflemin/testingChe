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
package test28;

class A {

    public String g;

    public String getF() {
        return getG();
    }

    public String getG() {
        return g;
    }

    public void setF(String f) {
        setG(f);
    }

    public void setG(String f) {
        this.g = f;
    }
}
