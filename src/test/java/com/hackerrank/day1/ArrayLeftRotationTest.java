package com.hackerrank.day1;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Scanner;
import java.util.function.BiConsumer;

import static com.hackerrank.day1.ArrayLeftRotation.arrayRotateLeft1;
import static com.hackerrank.day1.ArrayLeftRotation.arrayRotateLeft2;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class ArrayLeftRotationTest {
    private int[] a;

    @Before
    public void setUp() {
        a = new int[]{1, 2, 3, 4, 5};
    }

    @Test
    public void readData() {
        InputStream is = this.getClass().getResourceAsStream("/day1/array_rotate_left.txt");
        Scanner in = new Scanner(is);
        int n = in.nextInt();
        assertThat(n).isEqualTo(5);

        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        assertThat(a).containsExactly(1, 2, 3, 4, 5);

        while(!in.next().startsWith("/---")) {
            int d = in.nextInt();

            int vexpected[] = new int[n];
            for (int i = 0; i < n; i++) {
                vexpected[i] = in.nextInt();
            }

            System.out.println("d = " + d);
            System.out.println("Arrays.asList(vexpected) = " + asList(vexpected));
        }

        in.close();
    }

    @Test
    public void genericTest() {
        runTest(
            ArrayLeftRotation::arrayRotateLeft1,
            a,
            4,
            new int[] {5, 1, 2, 3, 4}
        );
    }

    public void runTest(
        BiConsumer<int[], Integer> f,
        int[] vinput,
        int d,
        int[] vexpected
    ) {
        f.accept(vinput, d);
        assertThat(a).containsExactly(vexpected);
    }

    @Test
    public void rotate1() {
        arrayRotateLeft1(a, 4);

        assertThat(a).containsExactly(5, 1, 2, 3, 4);
    }

    @Test
    public void rotate2_0() {
        arrayRotateLeft2(a, 0);

        assertThat(a).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    public void rotate2_1() {
        arrayRotateLeft2(a, 1000000009);

        assertThat(a).containsExactly(5, 1, 2, 3, 4);
    }

    @Test
    public void rotate2_2() {
        arrayRotateLeft2(a, 2);

        assertThat(a).containsExactly(3, 4, 5, 1, 2);
    }

    @Test
    public void rotate2_3() {
        arrayRotateLeft2(a, 3);

        assertThat(a).containsExactly(4, 5, 1, 2, 3);
    }
}
