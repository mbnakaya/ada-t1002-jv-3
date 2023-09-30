package io.ada.mbnakaya.aula6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClassroomBackup {

    public static void main(String[] args) throws IOException {
        // Mover arquivo/diretório
        // move(Path source, Path target, CopyOption... options)
//        Path pathFile = Path.of("src/main/resources/move2.txt");
//        Path pathDir = Path.of("src/main/resources/move/move.txt");
//        Files.move(pathDir, pathFile);

        // Deletar arquivo/diretório
        // delete(Path path)
        // deleteIfExists(Path path)
        Files.deleteIfExists(Path.of("src/main/resources/move"));
    }
}
