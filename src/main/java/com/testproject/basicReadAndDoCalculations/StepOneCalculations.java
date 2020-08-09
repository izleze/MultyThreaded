package com.testproject.basicReadAndDoCalculations;

import com.testproject.basicReadAndDoCalculations.doCalculationsWithStreams.WithParralelStream;
import com.testproject.basicReadAndDoCalculations.doCalculationsWithStreams.WithSimpleStream;
import com.testproject.basicReadAndDoCalculations.readWithScannerAndDoCalculations.ScannerReadAndCalculate;
import com.testproject.measureTime.MeasureMethodTimeGroups;
import com.testproject.measureTime.MeasureTime;
import com.testproject.measureTime.MethodMeasure;
import com.testproject.percentBar.PercentBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Class that combines all basic read, do calculations and print data class;
 */

public class StepOneCalculations {
    public static void measureStepOneRunTimeAverages(int timesToRunAverage) {

        List<MethodMeasure> methodMeasureList = new ArrayList<>(
                Arrays.asList(new ScannerReadAndCalculate(), new WithSimpleStream(), new WithParralelStream()));

        long allActions = timesToRunAverage * methodMeasureList.size();

        AtomicLong currentAction = new AtomicLong(0);
        if (currentAction.get() > allActions) {
            return;
        }

        PercentBar runnable = new PercentBar(allActions, currentAction);
        Thread thread = new Thread(runnable);
        thread.start();


        MeasureMethodTimeGroups.measureAverageTime(timesToRunAverage, methodMeasureList,
                "Step 1 control group for all simple read and do calculations methods", currentAction);

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void measureAverageScanner(int timesToRun) {
        AtomicLong action = new AtomicLong(0);
        if (action.get() > timesToRun) {
            return;
        }
        PercentBar runnable = new PercentBar(timesToRun, action);
        Thread thread = new Thread(runnable);
        thread.start();

        MeasureTime.measureMethodAverageTime(timesToRun, new ScannerReadAndCalculate(), "Measuring scanner: ", action);

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void measureAverageStream(int timesToRun) {
        AtomicLong action = new AtomicLong(0);
        if (action.get() > timesToRun) {
            return;
        }
        PercentBar runnable = new PercentBar(timesToRun, action);
        Thread thread = new Thread(runnable);
        thread.start();

        MeasureTime.measureMethodAverageTime(timesToRun, new WithSimpleStream(), "Measuring stream: ", action);

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void measureAverageParallelStream(int timesToRun) {
        AtomicLong action = new AtomicLong(0);
        if (action.get() > timesToRun) {
            return;
        }
        PercentBar runnable = new PercentBar(timesToRun, action);
        Thread thread = new Thread(runnable);
        thread.start();

        MeasureTime.measureMethodAverageTime(timesToRun, new WithParralelStream(), "Measuring parallel stream: ", action);
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
