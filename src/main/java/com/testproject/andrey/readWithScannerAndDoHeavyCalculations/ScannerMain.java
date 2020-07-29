package com.testproject.andrey.readWithScannerAndDoHeavyCalculations;

import com.testproject.andrey.measureTime.MeasureTime;
import com.testproject.andrey.service.ReadyForPrintService;

import java.util.Objects;
import java.util.Scanner;

public class ScannerMain {

    public static void main(String[] args) {
        MeasureTime.startMeasuring();
        printIteratively();
        MeasureTime.endMeasuringWithMessage("Measuring iteratively print");
    }

    private static void printIteratively() {
        Scanner innerScanner = ScannerRead.scannerReadDataFile();
        ReadyForPrintService readyForPrintService = new ReadyForPrintService();
        //remove the first line
        Objects.requireNonNull(innerScanner).nextLine();
        int counter = 0;
        while (Objects.requireNonNull(innerScanner).hasNextLine()) {
            System.out.println(readyForPrintService.dataToShow(innerScanner.nextLine()));
            counter++;
        }
        //expected 9357701
        System.out.println("Lines printed: " + counter);
    }
}
