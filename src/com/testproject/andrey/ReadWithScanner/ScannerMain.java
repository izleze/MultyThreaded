package com.testproject.andrey.ReadWithScanner;

import com.testproject.andrey.measureTime.MeasureTime;

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
        int counter = 0;
        while (Objects.requireNonNull(innerScanner).hasNextLine()) {
            System.out.println(innerScanner.nextLine());
            counter++;
        }
        //expected 9357701
        System.out.println("Lines printed: " + counter);
    }
}
