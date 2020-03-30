package com.testproject.andrey.ReadWithScanner.ProducerConsumer;

import com.testproject.andrey.ReadWithScanner.ScannerRead;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerOneThreadEach {

    private BlockingQueue<String> strings = new ArrayBlockingQueue<>(30);

    public void readAndPrintDataOneTreadEach() throws InterruptedException {
        Scanner scanner = ScannerRead.scannerReadDataFile();
        AtomicInteger countProduced = new AtomicInteger(0);
        AtomicInteger countConsumed = new AtomicInteger(0);

        final Runnable producer = () -> {
            while (true) {
                try {
                    if(scanner.hasNextLine()) {
                        strings.put(scanner.nextLine());
                        countProduced.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        };

        Thread produce = new Thread(producer);
        produce.start();

        final Runnable consumer = () -> {
            try {
                while (true) {
                    System.out.println(strings.take());
                    countConsumed.incrementAndGet();
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };

        Thread consume = new Thread(consumer);
        consume.start();

        Thread.sleep(90_000);

        System.out.println("Count produced: " + countProduced.get());
        System.out.println("Count consumed: " + countConsumed.get());
        System.out.println("Count missed: " + (countProduced.get() - countConsumed.get()));
        System.out.println("Count missed: " + (9357701 - countConsumed.get()));


        produce.interrupt();
        consume.interrupt();

    }
}
