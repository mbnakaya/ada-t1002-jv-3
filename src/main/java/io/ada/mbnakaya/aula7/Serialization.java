package io.ada.mbnakaya.aula7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Serialization {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("src/main/resources/aula7/payment.txt");
        if (!path.toFile().exists()) Files.createFile(path);

        // Serialização ==> converter um objeto em memória para uma stream de bytes

        // Objeto que será serializado e gravado em arquivo txt
        Payment payment = new Payment(2L, 0L, 10L, "BRL");

        // Declarando de um FileOutputStream
        OutputStream outputStream = new FileOutputStream("src/main/resources/aula7/payment.txt");

        // Declarando um escritor em buffer (para otimizar o processo de escrita no arquivo)
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        // Declarando um serializador de objetos
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

        try {
            objectOutputStream.writeObject(payment);
        } catch (NotSerializableException ex) {
            System.out.println("Objeto não serializável :(");
        } finally {
            objectOutputStream.close();
            bufferedOutputStream.close();
            outputStream.close();
        }

        // Deserialização ==> converter uma stream de bytem em um objeto

        // Declarando de um FileInputStream
        InputStream inputStream = new FileInputStream("src/main/resources/aula7/payment.txt");

        // Declarando um leitor em buffer (para otimizar o processo de leitura)
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        // Declarando um serializador de objetos
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

        try {
            var object = objectInputStream.readObject();
            if (object instanceof Payment p) System.out.println(p);
        } catch (NotSerializableException ex) {
            System.out.println("Objeto não serializável :(");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            objectOutputStream.close();
            bufferedOutputStream.close();
            outputStream.close();
        }
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
