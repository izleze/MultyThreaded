package com.testproject.basicReadAndDoCalculations.readWithScannerAndDoCalculations;

import com.testproject.IOoperations.ScannerRead;
import com.testproject.measureTime.MethodMeasure;
import com.testproject.service.ReadyForPrintService;

import java.util.Objects;
import java.util.Scanner;

public class ScannerReadAndCalculate implements MethodMeasure {

    private static void printIteratively() {
        System.out.println("Starting scanner reader");
        ScannerRead.makeScannerNull();
        Scanner innerScanner = ScannerRead.scannerReadDataFile();
        ReadyForPrintService readyForPrintService = new ReadyForPrintService();

        //remove the first line
        int counter = 0;
        while (Objects.requireNonNull(innerScanner).hasNextLine()) {
            readyForPrintService.dataToShow(innerScanner.nextLine());
            counter++;
        }

        System.out.println("Expected calculations 9357701");
        System.out.println("Calculations: " + counter);
    }

    @Override
    public void measurementMethod() {
        printIteratively();
    }

    @Override
    public String toString() {
        return "Scanner";
    }
}
