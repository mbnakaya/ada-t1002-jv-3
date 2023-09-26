package io.ada.mbnakaya.aula4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Classroom {

    public static void main(String[] args) {

        // Interface Stream<T>

        // Streams finitas
        Stream<String> strVazia = Stream.empty();
        System.out.println("Stream vazia: " + Arrays.toString(strVazia.toArray()));

        Stream<Integer> intSeq = Stream.of(1,2,3,4);
        System.out.println("Stream numerica: " + Arrays.toString(intSeq.toArray()));

        Stream.Builder<String> streamBuilder = Stream.builder();
        Stream<String> strBuild = streamBuilder.add("Um").add("Dois").add("Tres").build();
        System.out.println("Stream builder: " + Arrays.toString(strBuild.toArray()));

        System.out.println();

        // Streams infinitas
        Supplier<Double> supplier = () -> (Math.random() * 10) + 1;
        Stream<Double> infinityStream = Stream.generate(supplier);

        // CUIDADO!! Executa infinitamente
        UnaryOperator<Integer> unaryOperator = x -> x + 10;
        Stream<Integer> infinityStream2 = Stream.iterate(10, unaryOperator);

        Predicate<Integer> predicate = x -> x <= 100;
        Stream<Integer> finityStream = Stream.iterate(10, predicate, unaryOperator);
        System.out.println("Stream iterate com Predicate: " + Arrays.toString(finityStream.toArray()));
        System.out.println();

        // count()
        // Método final -> encerra a stream
        // Conta quantos elementos existem na stream
        Predicate<Integer> predicate1 = x -> x <= 100;
        Stream<Integer> finityStream1 = Stream.iterate(10, predicate, unaryOperator);
        long count = finityStream1.count();
        System.out.println(count);

        // min() e max()
        // Retornam o menor e o maior valor de uma stream, com base em um Comparator
        // Utilizam um Comparator<T> ==> (x,y) -> x - y
        // Retorna um Optional
        Predicate<Integer> predicate2 = x -> x <= 100;
        Stream<Integer> finityStream2 = Stream.iterate(10, predicate, unaryOperator);
        System.out.println(finityStream2.max((x,y) -> x - y).get());

        // findFirst()
        // Retorna o primeiro elemento da stream
        // Retorna um Optional
        Predicate<Integer> predicate3 = x -> x <= 100;
        Stream<Integer> finityStream3 = Stream.iterate(10, predicate, unaryOperator);
        System.out.println(finityStream3.findFirst().get());

        // findAny()
        // Retorna qualquer elemento dentro de uma stream
        // Retorna um Optional
        // Nem sempre irá retornar o mesmo resultado (utiliza paralelismo)
        Predicate<Integer> predicate4 = x -> x <= 100;
        Stream<Integer> finityStream4 = Stream.iterate(10, predicate, unaryOperator);
        finityStream4.findAny().ifPresent(System.out::println);

        // allMatch(), anyMatch(), noneMatch()
        // Validam os elementos de uma stream com base em um Predicate (nem sempre percorrem toda a stream)
        // Recebem um Predicate<T>
        // Retornam um Boolean
        List<String> list = List.of("Java", "Kotlin", "Ruby", "PHP", "Javascript");
        Predicate<String> predicate5 = x -> x.charAt(0) == 'J';

        System.out.println("allMatch() em Stream infinita: " + list.stream().allMatch(predicate5));
        System.out.println("anyMatch() em Stream infinita: " + list.stream().anyMatch(predicate5));
        System.out.println("noneMatch() em Stream infinita: " + list.stream().noneMatch(predicate5));
        System.out.println();


        // Podem ser usados com Stream infinita:
        Predicate<Integer> predicate6 = x -> x % 2 == 0;
        Stream<Integer> infinityStreamInt1 = Stream.iterate(1, x -> x + 1);
        Stream<Integer> infinityStreamInt2 = Stream.iterate(1, x -> x + 1);
        Stream<Integer> infinityStreamInt3 = Stream.iterate(1, x -> x + 1);

        System.out.println("allMatch() em Stream infinita: " + infinityStreamInt1.allMatch(predicate6));
        System.out.println("anyMatch() em Stream infinita: " + infinityStreamInt2.anyMatch(predicate6));
        System.out.println("noneMatch() em Stream infinita: " + infinityStreamInt3.noneMatch(predicate6));
        System.out.println();

        // forEach()
        // Percorre os elementos de uma stream
        // Recebe um Consumer<T>
        list.stream().forEach(System.out::println);
        System.out.println();

        // reduce()
        // Combina os elementos de uma stream em um único objeto com base em uma BinaryOperator<T>
        var listR = List.of("J", "a", "v", "a");

        StringBuilder oldSchool = new StringBuilder();
        for (String s : listR) oldSchool.append(s);
        System.out.println(oldSchool);

        BinaryOperator<String> binaryOperator = (x,y) -> x + y;

        // Optional<T> reduce(BinaryOperator<T>)
        listR.stream().reduce(binaryOperator).ifPresent(System.out::println);

        // T reduce(T identity, BinaryOperator<T>)
        System.out.println(listR.stream().reduce("Estamos codando em: ", binaryOperator));

        // <U> U reduce(U identity, BiFunction<U, ? super T,U>, BinaryOperator<U>)
        // O último parâmetro é usado para streams paralelas
        BiFunction<Integer, String, Integer> biFunction = (x,y) -> x+y.length();
        System.out.println(listR.stream().reduce(0, biFunction, Integer::sum));

        System.out.println();

        // collect()
        // Tipo especial de redução
        // <R> R collect(Supplier<R>, BiConsumer<R, ? super T>, BiConsumer<R,R>)
        String collectResult = listR.stream().collect(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append
        ).toString();
        System.out.println(collectResult);

        System.out.println(listR.stream().collect(Collectors.joining()));

        System.out.println(listR.stream().collect(Collectors.toSet()));
        System.out.println();

        // Métodos Intermediários

        // filter()
        // Filtra os dados de uma stream com base em um Predicate
        Stream<String> streamFilter = Stream.of("MacOS", "Linux", "Windows");
        streamFilter.filter(x -> x.startsWith("L")).forEach(System.out::println);

        // distinct()
        // Remove itens duplicados na stream
        Stream<Character> streamDistinct = Stream.of('c', 'a', 'r', 'r', 'o');
        streamDistinct.distinct().forEach(System.out::print);
        System.out.println();

        // skip() e limit()
        // Muito utilizado para trabalhar com streams infinitas
        Stream<Integer> streamSkipLimit = Stream.iterate(0, x -> 10 + x);
        streamSkipLimit.skip(3).limit(10).forEach(System.out::println);
        System.out.println();

        // map()
        // Converte uma stream em outra stream (um para um)
        Stream<String> streamMap = Stream.of("Japao", "Argentina", "Vietna", "Armenia");
        streamMap.map(x -> x.charAt(0)).forEach(System.out::print);
        System.out.println();
        System.out.println();

        // flatMap()
        // Concatena as streams em uma única stream
        var lista1 = List.of();
        var lista2 = List.of("um", "dois");
        var lista3 = List.of("três", "quatro");
        var streamFlatMap = Stream.of(lista1, lista2, lista3);

        streamFlatMap.flatMap(Collection::stream).forEach(System.out::println);
        System.out.println();

        // sorted()
        // Ordena uma stream com base em um Comparator
        List<Character> streamSorted = List.of('a', 'f', 'c');

        streamSorted.stream().sorted().forEach(System.out::print);
        System.out.println();
        streamSorted.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println();

        // peek()
        // Bloco de execução de uma stream antes de retornar um valor final
        Stream<String> streamPeek = Stream.of("Azul", "Vermelho", "Amarelo");
        var result = streamPeek.filter(x -> x.startsWith("A")).peek(System.out::println).count();
        System.out.println(result);
    }
}
