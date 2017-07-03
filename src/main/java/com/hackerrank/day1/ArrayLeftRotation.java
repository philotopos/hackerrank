package com.hackerrank.day1;

import static java.lang.System.arraycopy;

public class ArrayLeftRotation {
    public static void arrayRotateLeft1(int[] a, int d) {
        for (int i = 0; i < d % a.length; i++) {
            int tmp = a[0];
            arraycopy(a, 1, a, 0, a.length - 1);
            a[a.length - 1] = tmp;
        }
    }

    public static void arrayRotateLeft2(int[] a, int d) {
        int n = a.length;
        int dr = d % n;

        if (dr == 0) {
            return;
        }

        if (dr <= n - dr) {
            int[] vtmp = new int[dr];
            arraycopy(a, 0, vtmp, 0, dr);
            arraycopy(a, dr, a, 0, n - dr);
            arraycopy(vtmp, 0, a, n - dr, dr);
        } else {
            int[] vtmp = new int[n - dr];
            arraycopy(a, dr, vtmp, 0, n - dr);
            arraycopy(a, 0, a, n - dr, dr);
            arraycopy(vtmp, 0, a, 0, n - dr);
        }
    }
}
