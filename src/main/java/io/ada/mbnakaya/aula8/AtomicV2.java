package io.ada.mbnakaya.aula8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicV2 {

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

class WalletV2 {
    private String currency;
    private AtomicLong balance;

    public WalletV2() {
        this.currency = "BRL";
        this.balance = new AtomicLong(0L);
    }

    public String getCurrency() {
        return currency;
    }

    public AtomicLong getBalance() {
        return balance;
    }

    public void credit(Long value) { this.balance.addAndGet(value); }
    public void debit(Long value) { this.balance.addAndGet(-value); }
}
