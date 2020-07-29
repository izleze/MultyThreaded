package com.testproject.andrey.PrintWithStreams;

import com.testproject.andrey.measureTime.MeasureTime;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class PrintWithParralelStream {
    public static void main(String[] args) {
        MeasureTime.startMeasuring();
        readAndPrintFileParallelStream();
        MeasureTime.endMeasuringWithMessage("Measuring parallel stream print");
    }

    private static void readAndPrintFileParallelStream() {
        List<String> fileLines = Collections.emptyList();

        try {
            fileLines = Files.readAllLines(Paths.get("data/data_q4_2018.csv"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileLines
                .parallelStream()
                .forEach(System.out::println);
    }
}
