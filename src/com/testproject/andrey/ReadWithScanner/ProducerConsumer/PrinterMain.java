package com.testproject.andrey.ReadWithScanner.ProducerConsumer;

import com.testproject.andrey.ReadWithScanner.ScannerRead;
import com.testproject.andrey.measureTime.MeasureTime;

public class PrinterMain {
    public static void main(String[] args) throws InterruptedException {
        multipleThreads();
        //9357701
    }

    private static void oneThreadEach() throws InterruptedException {
        ProducerConsumerOneThreadEach oneThreadEach = new ProducerConsumerOneThreadEach();
        ScannerRead.scannerReadDataFile();

        MeasureTime.startMeasuring();
        oneThreadEach.readAndPrintDataOneTreadEach();
        MeasureTime.endMeasuring();
    }

    private static void multipleThreads() throws InterruptedException {
        ProducerConsumerMultipleThreads multipleThreads = new ProducerConsumerMultipleThreads();
        ScannerRead.scannerReadDataFile();

        MeasureTime.startMeasuring();
        multipleThreads.readAndPrintDataMultipleThreads();
        MeasureTime.endMeasuring();
    }

}
