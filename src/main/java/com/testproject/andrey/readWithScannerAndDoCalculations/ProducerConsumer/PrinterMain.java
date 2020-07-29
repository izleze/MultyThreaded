package com.testproject.andrey.readWithScannerAndDoCalculations.ProducerConsumer;

import com.testproject.andrey.measureTime.MeasureTime;
import com.testproject.andrey.readWithScannerAndDoCalculations.ScannerRead;

public class PrinterMain {
    public static void main(String[] args) throws InterruptedException {
        oneProducerTwoConsumers();
    }

    private static void oneThreadEach() throws InterruptedException {
        ProducerConsumerOneThreadEach oneThreadEach = new ProducerConsumerOneThreadEach();
        ScannerRead.scannerReadDataFile();

        MeasureTime.startMeasuring();
        oneThreadEach.readAndPrintDataOneTreadEach();
        MeasureTime.endMeasuringWithMessage("Ended measuring 1 producer scanner and 1 consumer thread");
        //9357701
    }

    private static void oneProducerTwoConsumers() throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        ScannerRead.scannerReadDataFile();

        MeasureTime.startMeasuring();
        producerConsumer.readAndPrintData();
        MeasureTime.endMeasuringWithMessage("Ended measuring 1 producer scanner and 2 consumer thread");
        //9357701
    }

}
