package com.testproject;

import com.testproject.basicReadAndDoCalculations.StepOneCalculations;
import com.testproject.optimization1.Optimization1Calculations;
import com.testproject.percentBar.PercentBar;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import static com.testproject.unzipper.UnzipUtility.unzipPathAndDest;

public class Main {

    public static void main(String[] args) throws IOException {
        //TODO call/write all methods and add their data to files
//        int timesToRunAverage = 1;
        Scanner readConsole = new Scanner(System.in);
        unzipPathAndDest();
        int choice = 0;
        System.out.println("What measurements do you want to do:\n" +
                "1. Measure basic read and do calculations\n" +
                "2. Measure optimization1");

        choice = readConsole.nextInt();
        switch (choice) {
            case 1: step1(readConsole);
                break;
            case 2: opt1(readConsole);
                break;
            case 3:
                break;
            default:
                System.out.println("Goodbye");
        }
    }

    /**
     * Method to do all basic actions implementation and to average their time
     */
    private static void step1(Scanner scanner) {
        //run calculations and printing basically
        System.out.println("What do you choose:\n" +
                "1. Measure scanner times: \n" +
                "2. Measure simple stream times: \n" +
                "3. Measure parallel stream times: \n" +
                "4. Measure all: ");
        int choice = scanner.nextInt();
        System.out.println("How many times to be run: ");
        int timesToRunAverage = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Starting to do scanner measurements");
                StepOneCalculations.measureAverageScanner(timesToRunAverage);
                System.out.println("End of scanner measurements");
                break;
            case 2:
                System.out.println("Starting to do simple stream measurements");
                StepOneCalculations.measureAverageStream(timesToRunAverage);
                System.out.println("End of simple stream measurements");
                break;
            case 3:
                System.out.println("Starting to do parallel stream measurements");
                StepOneCalculations.measureAverageParallelStream(timesToRunAverage);
                System.out.println("End of parallel stream measurements");
                break;
            case 4:
                System.out.println("Starting to do step 1 calculations:");
                StepOneCalculations.measureStepOneRunTimeAverages(timesToRunAverage);
                System.out.println("End to step 1 calculations");
                break;
            default:
                System.out.println("Goodbye");
        }
    }

    private static void opt1(Scanner scanner) {
        System.out.println("What do you choose:\n" +
                "1. Measure one read thread one calculate thread: \n" +
                "2. Measure one read two calculate threads: \n" +
                "3. Measure all: ");
        int choice = scanner.nextInt();
        System.out.println("How many times to be run: ");
        int timesToRunAverage = scanner.nextInt();

        switch (choice) {
            case 1:
                Optimization1Calculations.measureAverageScannerOneThreadEach(timesToRunAverage);
                break;
            case 2:
                Optimization1Calculations.measureAverageScannerOneThreadRead2ThreadsCalculate(timesToRunAverage);
                break;
            case 3:
                Optimization1Calculations.measureOptOneRunTimeAverages(timesToRunAverage);
            default:
                System.out.println("Goodbye");
        }
    }
}
