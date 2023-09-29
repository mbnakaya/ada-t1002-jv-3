package io.ada.mbnakaya.aula6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;

public class Classroom2 {

    public static void main(String[] args) throws IOException {

        // InputStream ==> classe abstrata que trata input em bytes
        // Reader ==> classe abstrata que trata input em caracteres
        InputStream inputStream = new FileInputStream("src/main/resources/test.txt");

        int index;
        while ((index = inputStream.read()) != -1) {
            System.out.print(index + " ");
        }
        inputStream.close();
        System.out.println();

        Reader reader = new FileReader("src/main/resources/test.txt");

        int indexR;
        while ((indexR = reader.read()) != -1) {
            System.out.print(indexR + " ");
        }
        reader.close();
        System.out.println();

        // OutputStream ==> classe abstrata que trata output em bytes
        // Writer ==> classe abstrata que trata output em caracteres
//        Reader reader2 = new FileReader("src/main/resources/test.txt");
//        OutputStream outputStream = new FileOutputStream("src/main/resources/test2.txt");
//
//        int indexO;
//        while ((indexO = reader2.read()) != -1) {
//            outputStream.write(indexO);
//        }
//        reader2.close();
//        outputStream.write(" COPIADO!!!".getBytes());
//        outputStream.close();

        /*
         * DESAFIO: consuma o conteúdo do arquivo test.txt e escreva-o em um novo arquivo writer.txt,
         * utilizando a classe Writer
         */

        // Buffers
//        Reader reader3 = new FileReader("src/main/resources/gg.txt");
//        Reader readerToBuffer = new FileReader("src/main/resources/gg.txt");
//        BufferedReader bReader = new BufferedReader(readerToBuffer);
//
//        System.out.println();
//        compare(reader3, bReader);
//        System.out.println();

        // NIO
//        String inputNIO = "SEEEEXTOU!!!";
//        Path nio = Path.of("src/main/resources/nio.txt");
//        Files.writeString(nio, inputNIO);
//        Files.readAllLines(nio).forEach(System.out::println);
    }

    private static void compare(Reader reader, BufferedReader bufferedReader) throws IOException {

        // Reader
        LocalDateTime timeReader = LocalDateTime.now();
        int i;
        while ((i = reader.read()) != -1) {}
        reader.close();
        System.out.println("Reader time: " + Duration.between(timeReader, LocalDateTime.now()).toMillis());

        // BufferedReader
        LocalDateTime timeBReader = LocalDateTime.now();
        int j;
        while ((j = bufferedReader.read()) != -1) {}
        reader.close();
        System.out.println("Buffered Reader time: " + Duration.between(timeBReader, LocalDateTime.now()).toMillis());
    }
}
