package com.hackerrank.day2;

import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

import static com.hackerrank.util.TestUtil.readExpectedOutput;
import static com.hackerrank.util.TestUtil.runAlgorithm;
import static org.assertj.core.api.Assertions.assertThat;

public class SparseArraysTest {
    @Test
    public void sparseArrayTest() throws Exception {
        String inputFileName = "/day2/sparse.in";
        String expectedOutputFileName = "/day2/sparse.out";

        List<String> expectedOutput = readExpectedOutput(expectedOutputFileName);

        Consumer<String[]> main = SparseArrays::main;
        List<String> actualOutput = runAlgorithm(inputFileName, main);

        actualOutput.forEach(System.out::println);

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}
