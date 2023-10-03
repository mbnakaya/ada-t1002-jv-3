package io.ada.mbnakaya.aula8;

import java.util.Arrays;

public class Parallelism {

    public static void main(String[] args) {

        /*
         * System Thread ==> são threads criadas e gerenciadas pela JVM que executam em background
         * Ex: garbage collector
         */

        /*
         * User-defined Thread ==> são threads criadas pelo usuário (programador)
         * Ex: new Thread()
         */

        // Thread daemon ==> não impede a conclusão do programa
        Thread threadDaemon = new Thread(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("DAEMON!!");
            } catch (InterruptedException e) {
                System.out.println("Sono interrompido");
            }
        });
        threadDaemon.setDaemon(true);
        threadDaemon.start();

        System.out.println("Thread Daemon:");

        // Atributos de uma thread
        Thread main = Thread.currentThread();
        Runnable minhaThreadRunnable = () -> {
            System.out.println("Thread Group: " + main.getThreadGroup());
            System.out.println("Thread Name: " + main.getName());
            System.out.println("Thread Priority: " + main.getPriority());
            System.out.println("Thread State: " + main.getState());
            System.out.println("Thread ID: " + main.getId());
            System.out.println("Thread Context Class Loader: " + main.getContextClassLoader());
            System.out.println("Thread Stacktrace: " + Arrays.toString(main.getStackTrace()));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Sono interrompido");
            }
        };
        Thread minhaThread = new Thread(minhaThreadRunnable);
        minhaThread.setName("MinhaThread");
        minhaThread.setPriority(Thread.MAX_PRIORITY);       // MIN_PRIORITY
        minhaThread.start();

        // Núcleos de processamento disponíveis
        System.out.println("CPU Cores: " + Runtime.getRuntime().availableProcessors());

        // Memória (RAM) disponível para a JVM
        System.out.println("Memória disponível: " + Runtime.getRuntime().freeMemory());
    }

    // Deadlock ==> dependência cruzada
    // Quando duas ou mais threads ficam bloqueadas indefinidamente, uma aguardando a conclusão da outra.

    // Starvation ==> dependência não satisfeita
    // Quando uma thread não consegue completar sua execução por falta de recursos ou por uma dependência nunca satisfeita

    // Livelock ==> caso especial de Deadlock
    // Qaundo duas ou mais treads distribuem locks entre elas, impossibilitando suas conclusões.

    // https://www.baeldung.com/jvm-max-threads
}
