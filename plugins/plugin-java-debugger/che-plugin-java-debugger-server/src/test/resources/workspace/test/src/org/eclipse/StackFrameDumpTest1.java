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
package org.eclipse;

public class StackFrameDumpTest1 {
    private static String v = "something";
    public static void main(String[] args) throws Exception {
        do1(1);
    }

    private static void do1(int i) {
        int j = 1;
        do2(String.valueOf(i + j));
    }

    private static void do2(String str) {
        System.out.println(str);
    }
}
