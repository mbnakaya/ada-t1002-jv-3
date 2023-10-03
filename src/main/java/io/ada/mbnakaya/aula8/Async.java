package io.ada.mbnakaya.aula8;

import java.util.concurrent.*;

public class Async {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        // ExecutorService (> Java 8)
        Runnable runnable = () -> System.out.println("ExecutorService!!");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println("Início");
        executorService.execute(runnable);
        System.out.println("Fim");

        // submit()
        Runnable runnable1 = () -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Executando...");
            }
        };

        Future<?> future = executorService.submit(runnable1);
        while (!future.isDone()) {
            System.out.println("Aguardando...");
        }
        System.out.println(future.get());

        // Timeout
        // future.get(1, TimeUnit.MILLISECONDS);

        // Interface Callable<V>
        Callable<Integer> callable = () -> 10 * 10;     // Sem parâmetros
        Future<Integer> futureInt = executorService.submit(callable);
        System.out.println(futureInt.get(3, TimeUnit.SECONDS));

        if (!executorService.isShutdown()) executorService.shutdown();

        // Agendamento de tasks
        ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> System.out.println("Task 1");
        Runnable task2 = () -> System.out.println("Task 2");
        Runnable task3 = () -> System.out.println("Task 3");

        scheduled.schedule(task1, 7, TimeUnit.SECONDS);
        scheduled.schedule(task2, 5, TimeUnit.SECONDS);
        scheduled.schedule(task3, 1, TimeUnit.SECONDS);

        if (!scheduled.isShutdown()) scheduled.shutdown();
    }
}
