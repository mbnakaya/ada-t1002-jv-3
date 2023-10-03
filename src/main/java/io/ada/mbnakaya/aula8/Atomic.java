package io.ada.mbnakaya.aula8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Atomic {

    public static void main(String[] args) {
        final int TASKS = 3;
        var wallet = new Wallet();
        ExecutorService service = Executors.newFixedThreadPool(TASKS);

        for (int i = 0; i < TASKS; i++) {
            service.execute(() -> {
                wallet.credit(10L);
                wallet.debit(1L);
                System.out.println(wallet.getBalance());
            });
        }
        service.shutdown();
    }
}

class Wallet {
    private String currency;
    private Long balance;

    public Wallet() {
        this.currency = "BRL";
        this.balance = 0L;
    }

    public String getCurrency() {
        return currency;
    }

    public Long getBalance() {
        return balance;
    }

    public void credit(Long value) { this.balance += value; }
    public void debit(Long value) { this.balance -= value; }
}
