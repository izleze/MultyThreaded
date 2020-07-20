package com.testproject.andrey.measureTime;

import java.time.Duration;
import java.time.Instant;

public class MeasureTime {

    private MeasureTime() {
    }

    private static Instant startTime;

    public static void startMeasuring() {
        startTime = Instant.now();
    }

    public static Duration endMeasuring() {
        Instant endTime = Instant.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Execution time in seconds: " + duration.getSeconds());
        startTime = null;
        return duration;
    }
}
