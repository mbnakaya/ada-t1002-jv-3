package io.ada.mbnakaya.aula4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intro {

    public static void main(String[] args) {
        List<Transaction> transactions = Transaction.getTransactions(5);
        getCollection(transactions);
//        getStream(transactions);
    }

    private static void getCollection(List<Transaction> transactions) {
        List<String> transactionIds = new ArrayList<>();
        for(Transaction t: transactions){
            transactionIds.add(t.getId());
        }
        System.out.println("Collection: " + Arrays.toString(transactionIds.toArray()));
    }

    private static void getStream(List<Transaction> transactions) {
        System.out.println("Stream: " + Arrays.toString(
                transactions.stream().map(Transaction::getId).toArray()
                ));
    }
}
