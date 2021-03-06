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
package test10;
import java.util.List;

class Test {
    static class Element{
    }

    static class A {
        private final List<Element> fList;

        public A(List<Element> list) {
            fList= list;
        }
    }
}
