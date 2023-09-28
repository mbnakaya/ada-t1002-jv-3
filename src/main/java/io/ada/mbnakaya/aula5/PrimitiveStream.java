package io.ada.mbnakaya.aula5;

import java.util.function.Function;
import java.util.function.IntToLongFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStream {

    public static void main(String[] args) {

        IntStream intStream = IntStream.of(1,2,3);

        LongStream longStream = LongStream.of(10L, 2L, 3L, 25L);

        DoubleStream doubleStream = DoubleStream.generate(Math::random);

        // Transformação de tipos
        // mapToInt(), mapToLong(), mapToDouble()
//        intStream.mapToLong(x -> (long) x);
        longStream.mapToDouble(x -> (double) x);
        doubleStream.mapToInt(x -> (int) x);

        // Estatisticas de streams
        // summaryStatistics() ==> devolve um consumer para facilitar certas operações
        System.out.println(intStream.summaryStatistics().getAverage());
    }
}
