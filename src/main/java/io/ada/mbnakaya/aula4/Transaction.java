package io.ada.mbnakaya.aula4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Transaction {

    private String id;

    private String value;
    private LocalDateTime createdAt;

    public Transaction(String id, String value, LocalDateTime createdAt) {
        this.id = id;
        this.value = value;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static List<Transaction> getTransactions(int count) {
        List<Transaction> transactions = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            transactions.add(new Transaction(
                    String.valueOf((int) (Math.random() * 10) + 1), String.format("Transaction %s", i), LocalDateTime.now())
            );
        }
        return transactions;
    }
}
