package io.ada.mbnakaya.aula7;

public class Parallelism {

    public static void main(String[] args) {

        // Task ==> menor unidade programável de rotina em um Sistema
        // Thread ==> menor unidade de execução em um Sistema
        // Processo ==> conjunto de tasks realizadas por uma ou mais treads

        Runnable runnable = () -> System.out.print("Hello ");   // zero parâmetros
        new Thread(runnable).start();
        System.out.print("world!");
        // Sem garantia de ordem de execução

        System.out.println();

        Runnable printHeader = () -> System.out.println("Número de loops:");
        Runnable printLoops = () -> {
            for (int i = 0; i <= 100; i++) {
                System.out.println("Loop " + i);
            }
        };
        new Thread(printHeader).start();
        new Thread(printLoops).start();
        new Thread(runnable).start();
    }
}
