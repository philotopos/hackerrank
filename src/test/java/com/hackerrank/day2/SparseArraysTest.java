package com.hackerrank.day2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;

import static alexh.Unchecker.uncheckedGet;
import static java.nio.file.Files.readAllLines;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class SparseArraysTest {
    @Test
    public void readFile() throws Exception {
        String inputFileName = "/day2/sparse.in";
        String expectedOutputFileName = "/day2/sparse.out";

        List<String> expectedOutput = readExpectedOutput(expectedOutputFileName);

        Consumer<String[]> main = SparseArrays::main;
        List<String> actualOutput = runAlgorithm(inputFileName, main);

        actualOutput.forEach(System.out::println);

        assertThat(actualOutput).isEqualTo(expectedOutput);

    }

    private List<String> runAlgorithm(String inputFileName, Consumer<String[]> algorithmImplementation) {
        InputStream is = this.getClass().getResourceAsStream(inputFileName);
        assertThat(is).isNotNull();

        InputStream inBackup = System.in;
        PrintStream outBackup = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        System.setIn(is);
        System.setOut(new PrintStream(baos));

        algorithmImplementation.accept(new String[]{});

        System.setIn(inBackup);
        System.setOut(outBackup);

        return asList(baos.toString().split("\n|\r\n"));
    }

    private List<String> readExpectedOutput(String filePath) {
        return uncheckedGet(() -> readAllLines(Paths.get(this.getClass().getResource(filePath).toURI())));
    }
}
