package com.testproject.andrey.ReadWithScanner.ProducerConsumer;

import com.testproject.andrey.ReadWithScanner.ScannerRead;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

//consumer 1 producers 3
public class ProducerConsumerMultipleThreads {

    private BlockingQueue<String> strings = new ArrayBlockingQueue<>(30);

    private volatile boolean ready = false;

    public void readAndPrintDataMultipleThreads() throws InterruptedException {
        Scanner scanner = ScannerRead.scannerReadDataFile();
        AtomicInteger countProduced = new AtomicInteger(0);
        AtomicInteger countConsumed = new AtomicInteger(0);

        final Runnable producer = () -> {
            while (!ready) {
                try {
                    if(scanner.hasNextLine()) {
                        strings.put(scanner.nextLine());
                        countProduced.incrementAndGet();
                    } else {
                        if (strings.isEmpty()) ready = true;
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        };

        Thread produce = new Thread(producer);
        Thread produce1 = new Thread(producer);
        Thread produce2 = new Thread(producer);
        produce.start();
        produce1.start();
        produce2.start();

        final Runnable consumer = () -> {
            try {
                while (!ready) {
                    System.out.println(strings.take());
                    countConsumed.incrementAndGet();
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };

        Thread consume = new Thread(consumer);
        consume.start();

        System.out.println("Count produced: " + countProduced.get());
        System.out.println("Count consumed: " + countConsumed.get());
        System.out.println("Count missed: " + (countProduced.get() - countConsumed.get()));
        System.out.println("Count missed: " + (9357701 - countConsumed.get()));

        produce.interrupt();
        produce1.interrupt();
        produce2.interrupt();
        consume.interrupt();
    }
}
