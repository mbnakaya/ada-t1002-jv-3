package io.ada.mbnakaya.aula5;

import java.util.stream.Stream;

public class Pipelines {

    public static void main(String[] args) {

        // Stream de números "aleatórios"
        Stream<Double> integerStream = Stream.generate(Math::random);

        // Filtre os números pares e positivos, ordenando e limitando a 10 elementos e, por fim, imprimindo o resultado
    }
}
