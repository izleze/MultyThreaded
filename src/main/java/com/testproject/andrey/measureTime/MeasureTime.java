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
        System.out.println(
                String.format("Execution time in %d hours %d minutes %d seconds %d nanoseconds",
                        duration.toHoursPart(), duration.toMinutesPart(),
                        duration.toSecondsPart(), duration.toNanosPart()));
        startTime = null;
        return duration;
    }

    public static void endMeasuringWithMessage(String message) {
        endMeasuring();
        System.out.println("Above measuring is for " + message);
    }
}
