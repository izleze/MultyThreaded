package com.testproject.basicReadAndDoCalculations.doCalculationsWithStreams;

import com.testproject.measureTime.MethodMeasure;
import com.testproject.service.ReadyForPrintService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class WithParralelStream implements MethodMeasure {

    private static void readAndPrintFileParallelStream() {
        System.out.println("Starting parrallel stream:");
        Stream<String> fileLines = Stream.<String>builder().build();

        try {
            fileLines = Files.lines(Paths.get("data/data_q4_2018.csv"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ReadyForPrintService readyForPrintService = new ReadyForPrintService();

        AtomicLong counter = new AtomicLong();
        fileLines
                .parallel()
                .map(readyForPrintService::dataToShow)
                .forEach(s -> counter.getAndIncrement());

        System.out.println("Expected calculations 9357701");
        System.out.println("Calculations: " + counter.get());

        System.out.println("END");
    }

    @Override
    public void measurementMethod() {
        readAndPrintFileParallelStream();
    }

    @Override
    public String toString() {
        return "Parralel stream";
    }
}
