package com.testproject.andrey.readWithScannerAndDoCalculations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.testproject.andrey.unzipper.UnzipUtility.unzipPathAndDest;

public class ScannerRead {

    private ScannerRead() {
    }

    private static Scanner scanner = null;

    public static Scanner scannerReadDataFile() {
        unzipPathAndDest();
        if (scanner == null) {
            try {
                scanner = new Scanner(
                        new File("data/data_q4_2018.csv"));
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return scanner;
    }
}
