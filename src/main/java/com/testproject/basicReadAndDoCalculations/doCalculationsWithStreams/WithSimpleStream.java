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

public class WithSimpleStream implements MethodMeasure {

    private static void readAndPrintFileStream() {
        System.out.println("Starting simple stream");
        List<String> fileLines = Collections.emptyList();
        try {
            fileLines = Files.readAllLines(Paths.get("data/data_q4_2018.csv"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReadyForPrintService readyForPrintService = new ReadyForPrintService();

        AtomicLong counter = new AtomicLong();
        fileLines.stream()
                .map(readyForPrintService::dataToShow)
                .forEach(s -> counter.getAndIncrement());

        System.out.println("Expected calculations 9357701");
        System.out.println("Calculations: " + counter.get());
    }

    @Override
    public void measurementMethod() {
        readAndPrintFileStream();
    }

    @Override
    public String toString() {
        return "Simple Stream";
    }
}
