package com.hackerrank.day3;

import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

import static com.hackerrank.util.TestUtil.readExpectedOutput;
import static com.hackerrank.util.TestUtil.runAlgorithm;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    @Test
    public void solutionTest() throws Exception {
        String inputFileName = "/day3/test.in";
        String expectedOutputFileName = "/day3/test.out";

        List<String> expectedOutput = readExpectedOutput(expectedOutputFileName);

        Consumer<String[]> main = Solution::main;
        List<String> actualOutput = runAlgorithm(inputFileName, main);

        actualOutput.forEach(System.out::println);

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}
