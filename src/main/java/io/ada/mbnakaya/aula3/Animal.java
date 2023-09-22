package io.ada.mbnakaya.aula3;

public class Animal {

    private String especie;
    private Boolean podeAndar;
    private Boolean podeVoar;

    public Animal(String especie, Boolean podeAndar, Boolean podeVoar) {
        this.especie = especie;
        this.podeAndar = podeAndar;
        this.podeVoar = podeVoar;
    }

    public String getEspecie() { return especie; }

    public Boolean podeAndar() { return podeAndar; }

    public Boolean podeVoar() { return podeVoar; }
}
