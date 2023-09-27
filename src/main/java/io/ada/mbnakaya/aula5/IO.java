package io.ada.mbnakaya.aula5;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;

import static java.nio.file.StandardOpenOption.CREATE;

public class IO {

    public static void main(String[] args) throws IOException {

        // root (diretório raiz) ==> /
        // path (caminho de um arquivo/sub-diretório)
        // absolute path (caminho absoluto) ==> /usr/aluno/documentos/planilha.csv
        // relative path (caminho relativo) ==> aluno/documentos/planilha.csv
        // OBS: tudo o que é relativo é relativo à algo

        /*
         * Java IO vs NIO
         *
         * IO ==> carrega o arquivo byte a byte em memória e utiliza o blocking mode (aguarda a conclusão de uma operação
         * antes mesmo de retornar o processo)
         *
         * NIO (New IO) ==> possui Buffer (carrega partes do arquivo em memória), converte bytes em caracteres legíveis,
         * permite multiplexação e oferece o non-blocking mode (para trabalhar com as partes já carregadas do arquivo)
         */

        // Java IO (File) -> objeto representando o caminho de um arquivo
        // File(String pathname) || File(String parent, String child)
        // File(File parent, String child) || File(String child, File parent)
        // File(URI uri)
        // ...
        File arquivoIO = new File("src/main/resources/test.txt");

        // Java NIO (Path) -> interface representando o caminho de um arquivo
        // Path.of(String, String...)
        // Path.of(String, String...)
        // Path.of("src ", "main/", "resources/", "test.txt");
        // ALTERNATIVA: Paths.get()
        Path arquivoNIO = Path.of("src/main/resources/test.txt");

        // File <==> Path
        File fromPath = arquivoNIO.toFile();
        Path fromFile = arquivoIO.toPath();

        // DESAFIO 1: Imprime se existir (utilizando interface funcional)
        // ...

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
        Files.createDirectories(Path.of("src/main/resources/teste"));

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
