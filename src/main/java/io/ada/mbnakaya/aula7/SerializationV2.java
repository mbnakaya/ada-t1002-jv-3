package io.ada.mbnakaya.aula7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializationV2 {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("src/main/resources/aula7/payment_v2.txt");
        if (!path.toFile().exists()) Files.createFile(path);

        // Serialização ==> converter um objeto em memória para uma stream de bytes

        // Objeto que será serializado e gravado em arquivo txt
        Payment payment = new Payment(2L, 0L, 10L, "BRL");

        Files.writeString(path, payment.toString());
        Files.write(path, payment.toString().getBytes());
    }

    static class Payment implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;
        private Long id;
        private Long discount;
        private Long total;
        private transient String currency;      // Omitir o atributo da serialização

        public Payment(Long id, Long discount, Long total, String currency) {
            this.id = id;
            this.discount = discount;
            this.total = total;
            this.currency = currency;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getDiscount() {
            return discount;
        }

        public void setDiscount(Long discount) {
            this.discount = discount;
        }

        public Long getTotal() {
            return total;
        }

        public void setTotal(Long total) {
            this.total = total;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        @Override
        public String toString() {
            return "Payment{" +
                    "id=" + id +
                    ", discount=" + discount +
                    ", total=" + total +
                    ", currency='" + currency + '\'' +
                    '}';
        }
    }
}
