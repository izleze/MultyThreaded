package com.testproject.andrey.doCalculationsWithStreams;

import com.testproject.andrey.measureTime.MeasureTime;
import com.testproject.andrey.service.ReadyForPrintService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class PrintWithStream {
    public static void main(String[] args) {
        MeasureTime.startMeasuring();
        readAndPrintFileStream();
        MeasureTime.endMeasuringWithMessage("Measuring single stream print");
    }

    private static void readAndPrintFileStream() {
        Stream<String> fileLines = Stream.<String>builder().build();
        try {
            fileLines = Files.lines(Paths.get("data/data_q4_2018.csv"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReadyForPrintService readyForPrintService = new ReadyForPrintService();

        fileLines
                .map(readyForPrintService::dataToShow)
                .forEach(System.out::println);
    }
}
