package io.ada.mbnakaya.aula6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Classroom {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/test.txt");

        // subpath(int beginIndex, int endIndex)

        // getRoot(), getParent(), getFileName()

        // resolve(Path other) || resolve(String other) ==> concatena paths
        // resolveSiblings(Path other) || resolveSiblings(String other) ==> resolve irmãos (paths filhos do mesmo diretório)

        // relativize(Path other) ==> retorna o caminho relativo ao caminho inicial
        // ex: (a/b/c).relativize(a/d) ==> ../../d

        // normalize() ==> normaliza o path de acordo com o referencial

        // toRealPath(LinkOptions... options)
        // Paths

        // createDirectory(Path dir, FileAttributes<?>... attrs)
        // Equivalente ao mkdir() do File
//        Files.createDirectories(Path.of("src/main/resources/teste"));

        // Copiar arquivo/diretório
        // copy(Path source, OutputStream out)
        // copy(Path source, Path target, CopyOption... options)
        // copy(InputStream in, Path target, CopyOption... options)

        // Mover arquivo/diretório
        // move(Path source, Path target, CopyOption... options)

        // Deletar arquivo/diretório
        // delete(Path path)
        // deleteIfExists(Path path)
    }
}
