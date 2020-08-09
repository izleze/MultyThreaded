package com.testproject.measureTime;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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
        System.out.printf("Execution time in %d hours %d minutes %d seconds %d nanoseconds%n",
                duration.toHoursPart(), duration.toMinutesPart(),
                duration.toSecondsPart(), duration.toNanosPart());
        startTime = null;
        return duration;
    }

    public static Duration endMeasuringWithMessage(String message) {
        Duration endDuration = endMeasuring();
        System.out.println("Above measuring is for " + message);
        return endDuration;
    }

    public static Duration measureMethodTime(MethodMeasure methodMeasure, String message, AtomicLong action) {
        startMeasuring();
        methodMeasure.measurementMethod();
        action.getAndIncrement();
        return endMeasuringWithMessage(message);
    }

    public static Duration measureMethodAverageTime(int timesToRunAverage, MethodMeasure methodMeasure, String message, AtomicLong action){
        List<Duration> durations = new ArrayList<>();
        for (int iteration =0; iteration < timesToRunAverage; iteration++) {
            System.out.println("Iteration " + (iteration + 1) + "/" + timesToRunAverage + " Started");
            durations.add(measureMethodTime(methodMeasure, message, action));
        }
        Duration duration = durations.stream()
                .reduce(Duration::plus)
                .orElseGet(() -> Duration.ofSeconds(0))
                .dividedBy(timesToRunAverage);

        System.out.printf("Average time in %d hours %d minutes %d seconds %d nanoseconds%n",
                duration.toHoursPart(), duration.toMinutesPart(),
                duration.toSecondsPart(), duration.toNanosPart());
        return duration;
    }
}
