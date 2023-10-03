package io.ada.mbnakaya.aula8;

import java.time.Duration;
import java.time.LocalTime;
import java.util.UUID;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        System.out.println("Default Stream:");
        getDefaultStreamDuration(Stream.generate(() -> UUID.randomUUID().toString()).limit(300));

        System.out.println();

        System.out.println("Parallel Stream:");
        getParallelStreamDuration(Stream.generate(() -> UUID.randomUUID().toString()).limit(300));
    }

    private static void getDefaultStreamDuration(Stream<String> stream) {
        var start = LocalTime.now();
        stream.forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("Duration: " + Duration.between(start, LocalTime.now()).toMillis());
    }

    private static void getParallelStreamDuration(Stream<String> stream) {
        var start = LocalTime.now();
        stream.parallel().forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("Duration: " + Duration.between(start, LocalTime.now()).toMillis());
    }
}
