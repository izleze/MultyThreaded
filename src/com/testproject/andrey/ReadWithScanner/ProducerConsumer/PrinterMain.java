package com.testproject.andrey.ReadWithScanner.ProducerConsumer;

import com.testproject.andrey.ReadWithScanner.ScannerRead;
import com.testproject.andrey.measureTime.MeasureTime;

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
