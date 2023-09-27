package io.ada.mbnakaya.resolution;

import java.util.function.BiFunction;

public class AtividadeInterfacesFuncionais {

    public static void main(String[] args) {
        var x = 10;
        var y = 10;
        var soma = new Soma();
        var subtracao = new Subtracao();
        var divisao = new Divisao();
        var multiplicacao = new Multiplicacao();

        // SOMA
        printar(soma);
        executar(x, y, soma);

        // SUBTRACAO
        printar(subtracao);
        executar(x, y, subtracao);

        // DIVISAO
        printar(divisao);
        executar(x, y, divisao);

        // MULTIPLICACAO
        printar(multiplicacao);
        executar(x, y, multiplicacao);
    }

    public static void executar(int x, int y, BiFunction biFunction) {
        var resultado = biFunction.apply(x,y);
        System.out.println(resultado);
        System.out.println();
    }

    private static void printar(Calculo calculo) {
        System.out.print("Resoltado da " + calculo.getOperation() + " : ");
    }

    interface Calculo extends BiFunction<Integer,Integer,Double> {
        String getOperation();
    }

    static class Soma implements Calculo {

        @Override
        public Double apply(Integer integer, Integer integer2) {
            return Double.valueOf(integer + integer2);
        }

        @Override
        public String getOperation() { return "SOMA"; }
    }

    static class Subtracao implements Calculo {

        @Override
        public Double apply(Integer integer, Integer integer2) {
            return Double.valueOf(integer - integer2);
        }

        @Override
        public String getOperation() { return "SUBTRACAO"; }
    }

    static class Divisao implements Calculo {

        @Override
        public Double apply(Integer integer, Integer integer2) {
            return (double) (integer / integer2);
        }

        @Override
        public String getOperation() { return "DIVISAO"; }
    }

    static class Multiplicacao implements Calculo {

        @Override
        public Double apply(Integer integer, Integer integer2) {
            return Double.valueOf(integer * integer2);
        }

        @Override
        public String getOperation() { return "MULTIPLICACAO"; }
    }
}
