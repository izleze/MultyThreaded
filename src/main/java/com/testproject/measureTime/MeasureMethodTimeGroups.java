package com.testproject.measureTime;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class MeasureMethodTimeGroups {

    public static void measureAverageTime(int timesToRunAverage, List<MethodMeasure> controlGroup, String message, AtomicLong action) {
        List<Duration> durations = new ArrayList<>();
        for (MethodMeasure methodMeasure : controlGroup) {
            System.out.println("Measure control group starting measurement for " + methodMeasure.toString());
            durations.add(MeasureTime.measureMethodAverageTime(timesToRunAverage, methodMeasure, methodMeasure.toString(), action));
        }
        Duration duration = durations.stream()
                .reduce(Duration::plus)
                .orElseGet(() -> Duration.ofSeconds(0))
                .dividedBy(controlGroup.size());

        System.out.printf("Average time for %s group is %d hours %d minutes %d seconds %d nanoseconds%n",
                message,
                duration.toHoursPart(), duration.toMinutesPart(),
                duration.toSecondsPart(), duration.toNanosPart());
    }
}
