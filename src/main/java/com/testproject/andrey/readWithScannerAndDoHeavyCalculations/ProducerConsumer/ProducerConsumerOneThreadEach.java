package com.testproject.andrey.readWithScannerAndDoHeavyCalculations.ProducerConsumer;

import com.testproject.andrey.readWithScannerAndDoHeavyCalculations.ScannerRead;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerOneThreadEach {

    private BlockingQueue<String> scannerLines = new LinkedBlockingQueue<>(40);
    private volatile boolean readerEnd = false;
    private volatile boolean consumerEnd = false;

    public void readAndPrintDataOneTreadEach() throws InterruptedException {
        Scanner scanner = ScannerRead.scannerReadDataFile();
        AtomicInteger countProduced = new AtomicInteger(0);
        AtomicInteger countConsumed = new AtomicInteger(0);

        final Runnable producer = () -> {
            try {
                while (!readerEnd) {
                    if(scanner.hasNextLine()) {
                        scannerLines.put(scanner.nextLine());
                        countProduced.incrementAndGet();
                    } else {
                        readerEnd = true;
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
                        consumerEnd = true;
                        break;
                    }
                    System.out.println(scannerLines.take());
                    countConsumed.incrementAndGet();
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };

        Thread consume = new Thread(consumer);
        consume.start();

        produce.join();
        consume.join();

        System.out.println("Count produced: " + countProduced.get());
        System.out.println("Count consumed: " + countConsumed.get());
        System.out.println("Count missed: " + (countProduced.get() - countConsumed.get()));
        System.out.println("Count missed: " + (9357701 - countConsumed.get()));


        produce.interrupt();
        consume.interrupt();

    }
}
