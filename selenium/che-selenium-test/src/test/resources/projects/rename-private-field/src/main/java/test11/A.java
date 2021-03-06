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
package test11;
import Test.Element;

import java.util.List;

class Test {
    static class Element{
    }

    static class A {
        private final List<Element> fList;

        public A(List<Element> list) {
            fList= list;
        }
        public List<Element> getList() {
            return fList;
        }
        public void setList(List<Element> newList) {
            fList= newList;
        }
    }

    {
        A a= new A(new List<Element>());
        a.setList(a.getList());
    }
}
