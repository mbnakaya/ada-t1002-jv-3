package io.ada.mbnakaya.aula3;

public class ValidaAndador implements Validador {
    @Override
    public Boolean valida(Animal animal) {
        return animal.podeAndar();
    }
}
