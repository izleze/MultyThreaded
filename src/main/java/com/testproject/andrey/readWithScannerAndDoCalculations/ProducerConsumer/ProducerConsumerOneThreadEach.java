package com.testproject.andrey.readWithScannerAndDoCalculations.ProducerConsumer;

import com.testproject.andrey.readWithScannerAndDoCalculations.ScannerRead;
import com.testproject.andrey.service.ReadyForPrintService;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerOneThreadEach {

    private BlockingQueue<String> scannerLines = new LinkedBlockingQueue<>(50);
    private volatile boolean readerEnd = false;

    public void readAndPrintDataOneTreadEach() throws InterruptedException {
        Scanner scanner = ScannerRead.scannerReadDataFile();
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
                    System.out.println(readyForPrintService.dataToShow(scannerLines.take()));
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };

        Thread consume = new Thread(consumer);
        consume.start();

        produce.join();
        consume.join();

    }
}
