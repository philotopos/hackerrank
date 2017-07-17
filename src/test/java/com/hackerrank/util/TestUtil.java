package com.hackerrank.util;

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

public class TestUtil {
    public static List<String> runAlgorithm(String inputFileName, Consumer<String[]> algorithmImplementation) {
        InputStream is = TestUtil.class.getResourceAsStream(inputFileName);
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

    public static List<String> readExpectedOutput(String filePath) {
        return uncheckedGet(() -> readAllLines(Paths.get(TestUtil.class.getResource(filePath).toURI())));
    }
}
