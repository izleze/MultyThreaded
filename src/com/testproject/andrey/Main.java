package com.testproject.andrey;

import com.testproject.andrey.unzipper.UnzipUtility;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //TODO call all methods and write their data to files
    }

    private static void readAndPrintFileStream() {
        List<String> fileLines = Collections.emptyList();
        try {
            fileLines = Files.readAllLines(Paths.get("data/data_q4_2018.csv"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileLines.stream()
                .forEach(System.out::println);

    }

    private static void readAndPrintFileParallelStream() {
        List<String> fileLines = Collections.emptyList();

        try {
            fileLines = Files.readAllLines(Paths.get("data/data_q4_2018.csv"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileLines.parallelStream().forEach(System.out::println);
    }
}
