package com.testproject.optimization1.ProducerConsumer;

import com.testproject.IOoperations.ScannerRead;
import com.testproject.measureTime.MethodMeasure;
import com.testproject.service.ReadyForPrintService;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerOneThreadEach implements MethodMeasure {

    private BlockingQueue<String> scannerLines = new LinkedBlockingQueue<>(50);
    private volatile boolean readerEnd = false;

    public void readAndPrintDataOneTreadEach() {
        Scanner scanner = ScannerRead.scannerReadDataFile();
        ScannerRead.makeScannerNull();
        ReadyForPrintService readyForPrintService = new ReadyForPrintService();

        final Runnable producer = () -> {
            try {
                while (!readerEnd) {
                    if(scanner.hasNextLine()) {
                        scannerLines.put(scanner.nextLine());
                    } else {
                        readerEnd = true;
                        break;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };

        Thread produce = new Thread(producer);
        produce.start();

        final Runnable consumer = () -> {
            try {
                while (true) {
                    if (readerEnd && scannerLines.isEmpty()) {
                        break;
                    }
                    readyForPrintService.dataToShow(scannerLines.take());
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };

        Thread consume = new Thread(consumer);
        consume.start();

        try {
            produce.join();
            consume.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void measurementMethod() {
        readAndPrintDataOneTreadEach();
    }
}
