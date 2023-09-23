package io.ada.mbnakaya.aula3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.*;

public class ClassroomPt2 {

    public static void main(String[] args) {

        /*
         * Recebe um argumento de qualquer tipo e não retorna nada (void)
         *
         * Consumer<T> ==> void accept(T)
         */
        Consumer<String> consumer = x -> System.out.println("Consumiu: " + x);
        consumer.accept("ADA!!!");
//        new ArrayList<>().forEach();  Utiliza o consumer como parâmetro

        /*
         * Não recebe nenhum argumento e retorna um valor do tipo indicado
         *
         * Supplier<T> ==> T get()
         */
        Supplier<Integer> supplier = () -> 47;
        System.out.println(supplier.get());

        /*
         * Recebe dois argumentos e permite uma expressão (muito utilizado para comparar elementos afim de ordená-los)
         * Retorna negatvo se x < y
         * Retorna positivo se x > y
         * Retorna zero se x == y
         *
         * Comparator<T> ==> int compare(T,T)
         */
        Comparator<Integer> comparator = (x,y) -> x - y;
        System.out.println(comparator.compare(3,1));

        Integer[] inteiros = new Integer[]{4, 5, 1, 9, 10, 3, 7, 2};
        System.out.println("Antes: " + Arrays.toString(inteiros));

        Arrays.sort(inteiros, comparator);
        System.out.println("Depois: " + Arrays.toString(inteiros));

        /*
         * Recebe um argumento de um tipo e retorna outro tipo. Muito utilizado para transformação e conversões.
         *
         * Function<T,R> ==> R apply(T)
         */
        Function<Integer, Boolean> function = x -> x > 10;
        System.out.println(function.apply(5));

        BiFunction<Integer, Integer, Boolean> biFunction = (x,y) -> x > y;
        System.out.println(biFunction.apply(10, 3));

        /*
         * Recebe um argumento de um tipo e retorna o mesmo tipo, de forma análoga ao Function.
         *
         * UnaryOperator<T> ==> T apply(T)
         */
        UnaryOperator<Integer> unary = x -> x + 10;
        System.out.println(unary.apply(5));

        BinaryOperator<Integer> binaryOperator = (x,y) -> x * y;
        System.out.println(binaryOperator.apply(10, 6));

        /*
         * Serve como um container (casca) para um objeto, podendo conter um valor ou não.
         * Caso o container esteja vazio, lança NoSuchElementException.
         *
         * Muito utilizado para consultas (geralmente em bancos) onde o retorno de um dado não é garantido.
         */
        BiFunction<Integer, Boolean, Optional> optFunction = (x,y) -> {
            if (y) return Optional.empty();
            else return Optional.of(x);
        };
        Optional<Integer> optionalOk = optFunction.apply(10, false);
        Optional<Integer> optionalNOk = optFunction.apply(10, true);

        System.out.println(optionalOk.get());   // .get() pode ser substituído por .orElseThrow()
        System.out.println(optionalNOk.orElseThrow());
    }
}
