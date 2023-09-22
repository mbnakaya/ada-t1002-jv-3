package io.ada.mbnakaya.aula3;

import java.util.ArrayList;
import java.util.List;

public class ClassroomPt1 {

    public static void main(String[] args) {
        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("Cachorro", true, false));
        animais.add(new Animal("Peixe", false, false));
        animais.add(new Animal("Pato", true, true));

        System.out.println("Estes andam: \n");
        imprimeOsQueAndam(animais);

        System.out.println("Estes voam: \n");
        imprimeOsQueVoam(animais);
    }

    private static void imprimeOsQueAndam(List<Animal> animais) {
        for (Animal animal : animais) {
            if (animal.podeAndar()) {
                System.out.println(animal.getEspecie());
            }
        }
    }

    private static void imprimeOsQueVoam(List<Animal> animais) {
        for (Animal animal : animais) {
            if (animal.podeVoar()) {
                System.out.println(animal.getEspecie());
            }
        }
    }
}
