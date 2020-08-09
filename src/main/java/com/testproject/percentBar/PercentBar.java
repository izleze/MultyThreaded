package com.testproject.percentBar;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class PercentBar implements Runnable {

    private long totalActions;
    private AtomicLong actionNumber;

    public PercentBar(long totalActions, AtomicLong actionNumber) {
        this.totalActions = totalActions;
        this.actionNumber = actionNumber;
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        AtomicLong lastLong = new AtomicLong(-1);

        while (actionNumber.get() < totalActions) {
            if (actionNumber.get() > lastLong.get()) {
                printProgress(startTime, totalActions, actionNumber.get());
                lastLong.getAndIncrement();
            }
        }
    }

    // credits to https://stackoverflow.com/a/39257908/9487419
    private static void printProgress(long startTime, long total, long current) {
        long eta = current == 0 ? 0 :
                (total - current) * (System.currentTimeMillis() - startTime) / current;

        String etaHms = current == 0 ? "N/A" :
                String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(eta),
                        TimeUnit.MILLISECONDS.toMinutes(eta) % TimeUnit.HOURS.toMinutes(1),
                        TimeUnit.MILLISECONDS.toSeconds(eta) % TimeUnit.MINUTES.toSeconds(1));

        StringBuilder string = new StringBuilder(140);
        int percent = (int) (current * 100 / total);
        string
                .append('\r')
                .append(String.join("", Collections.nCopies(percent == 0 ? 2 : 2 - (int) (Math.log10(percent)), " ")))
                .append(String.format(" %d%% [", percent))
                .append(String.join("", Collections.nCopies(percent, "=")))
                .append('>')
                .append(String.join("", Collections.nCopies(100 - percent, " ")))
                .append(']')
                .append(String.join("", Collections.nCopies(current == 0 ? (int) (Math.log10(total)) : (int) (Math.log10(total)) - (int) (Math.log10(current)), " ")))
                .append(String.format(" %d/%d, ETA: %s\n", current, total, etaHms));

        System.out.print(string);
    }
}
