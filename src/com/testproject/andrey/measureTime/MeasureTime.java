package com.testproject.andrey.measureTime;

import java.time.Duration;
import java.time.Instant;

public class MeasureTime {

    private MeasureTime() {
    }

    private static Instant startTime;
    private static Instant endTime;
    private static Duration duration;

    public static void startMeasuring() {
        startTime = Instant.now();
    }

    public static Duration endMeasuring() {
        endTime = Instant.now();
        duration = Duration.between(startTime, endTime);
        System.out.println("Execution time in seconds: " + duration.getSeconds());
        startTime = null;
        endTime = null;
        return duration;
    }
}
