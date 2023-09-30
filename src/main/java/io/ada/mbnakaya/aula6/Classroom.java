package io.ada.mbnakaya.aula6;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;

public class Classroom {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/test2.txt");

        // subpath(int beginIndex, int endIndex)
        System.out.println(path.subpath(1,3));

        // getRoot(), getParent(), getFileName()
        System.out.println(path.getRoot());
        System.out.println(path.getParent());
        System.out.println(path.getFileName());

        // resolve(Path other) || resolve(String other) ==> concatena paths
        // resolveSiblings(Path other) || resolveSiblings(String other) ==> resolve irmãos (paths filhos do mesmo diretório)
        System.out.println(Path.of("pai/resolve").resolve(path.getFileName()));
        System.out.println(path.resolveSibling("sibling"));

        // relativize(Path other) ==> retorna o caminho relativo ao caminho inicial
        // ex: (a/b/c).relativize(a/d) ==> ../../d
        Path abc = Path.of("a/b/c");
        Path ad = Path.of("a/d");
        System.out.println(abc.relativize(ad));

        // normalize() ==> normaliza o path de acordo com o referencial
        System.out.println(Path.of("/..//..//test//normalize.txt").normalize());

        // toRealPath(LinkOptions... options)
        // Paths
        System.out.println(path.toRealPath());

        // createDirectory(Path dir, FileAttributes<?>... attrs)
        // Equivalente ao mkdir() do File
        File file = new File("src/main/resources/test-mkdir");
//        file.mkdir()      Deprecated!!
        Files.createDirectories(file.toPath().resolve("files"));

        // Copiar arquivo/diretório
        // copy(Path source, OutputStream out)
        // copy(Path source, Path target, CopyOption... options)
        // copy(InputStream in, Path target, CopyOption... options)
//        Files.copy(file.toPath(), Path.of("src/main/resources/test-mkdir-copy"));

        // Mover arquivo/diretório
        // move(Path source, Path target, CopyOption... options)

        // Deletar arquivo/diretório
        // delete(Path path)
        // deleteIfExists(Path path)
    }
}
