package com.hackerrank.day1;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import static com.hackerrank.day1.Algorithm.algorithm;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class Algorithm {
    String name;
    BiConsumer<int[], Integer> fn;

    private Algorithm(String name, BiConsumer<int[], Integer> fn) {
        this.name = name;
        this.fn = fn;
    }


    public static Algorithm algorithm(String name, BiConsumer<int[], Integer> fn) {
        return new Algorithm(name, fn);
    }
}

@RunWith(JUnitParamsRunner.class)
public class ArrayLeftRotationParameterizedTest {
    private List<Algorithm> algorithms = asList(
        algorithm("Multiple rotations", ArrayLeftRotation::arrayRotateLeft1)
        ,algorithm("Rotation using temp array", ArrayLeftRotation::arrayRotateLeft2)
//        ,algorithm("Dummy", (a, d) -> {})
    );

    @Test
    @FileParameters(value = "classpath:array_rotate_left.csv", mapper = CsvWithHeaderMapper.class)
    public void csvWithHeader(String input, int d, String output) {
        int[] expected = toIntArray(output);

        for (Algorithm algorithm : algorithms) {
            int[] a = toIntArray(input);
            algorithm.fn.accept(a, d);
            assertThat(a)
                .as("Algorithm '%s' applied to ({%s}, %d)", algorithm.name, input.replaceAll("\\s+", ","), d)
                .containsExactly(expected)
            ;
        }
    }

    private int[] toIntArray(String arrayAsString) {
        return Arrays.stream(arrayAsString.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
