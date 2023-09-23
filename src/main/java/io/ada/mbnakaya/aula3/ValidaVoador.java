package io.ada.mbnakaya.aula3;

public class ValidaVoador implements Validador {

    @Override
    public Boolean valida(Animal animal) {
        return animal.podeVoar();
    }
}
