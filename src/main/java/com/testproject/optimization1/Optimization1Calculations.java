package com.testproject.optimization1;

import com.testproject.IOoperations.ScannerRead;
import com.testproject.basicReadAndDoCalculations.doCalculationsWithStreams.WithParralelStream;
import com.testproject.basicReadAndDoCalculations.doCalculationsWithStreams.WithSimpleStream;
import com.testproject.basicReadAndDoCalculations.readWithScannerAndDoCalculations.ScannerReadAndCalculate;
import com.testproject.measureTime.MeasureMethodTimeGroups;
import com.testproject.measureTime.MeasureTime;
import com.testproject.measureTime.MethodMeasure;
import com.testproject.optimization1.ProducerConsumer.ProducerConsumer;
import com.testproject.optimization1.ProducerConsumer.ProducerConsumerOneThreadEach;
import com.testproject.percentBar.PercentBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Optimization1Calculations {

    public static void measureAverageScannerOneThreadEach(int timesToRun) {
        AtomicLong action = new AtomicLong(0);
        if (action.get() > timesToRun) {
            return;
        }
        PercentBar runnable = new PercentBar(timesToRun, action);
        Thread thread = new Thread(runnable);
        thread.start();

        MeasureTime.measureMethodAverageTime(timesToRun, new ProducerConsumerOneThreadEach(), "Measuring scanner one thread read and one calculate: ", action);

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void measureAverageScannerOneThreadRead2ThreadsCalculate(int timesToRun) {
        AtomicLong action = new AtomicLong(0);
        if (action.get() > timesToRun) {
            return;
        }
        PercentBar runnable = new PercentBar(timesToRun, action);
        Thread thread = new Thread(runnable);
        thread.start();

        MeasureTime.measureMethodAverageTime(timesToRun, new ProducerConsumer(), "Measuring scanner one thread read and 2 calculate: ", action);

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void measureOptOneRunTimeAverages(int timesToRunAverage) {

        List<MethodMeasure> methodMeasureList = new ArrayList<>(
                Arrays.asList(new ProducerConsumer(), new ProducerConsumerOneThreadEach()));

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

}
