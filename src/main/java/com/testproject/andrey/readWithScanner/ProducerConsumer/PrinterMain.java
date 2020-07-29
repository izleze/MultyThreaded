package com.testproject.andrey.readWithScanner.ProducerConsumer;

import com.testproject.andrey.measureTime.MeasureTime;
import com.testproject.andrey.readWithScanner.ScannerRead;

public class PrinterMain {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerOneThreadEach oneThreadEach = new ProducerConsumerOneThreadEach();
        ScannerRead.scannerReadDataFile();

        MeasureTime.startMeasuring();
        oneThreadEach.readAndPrintDataOneTreadEach();
        MeasureTime.endMeasuringWithMessage("Ended measuring 1 producer scanner and 1 consumer thread");
        //9357701
    }

}
