package edu.fiuba.algo3.modelo.general;

public class Multiplicadorx2 extends Multiplicador {

    private final int factor = 2;

    @Override
    public int modificarPuntaje(int puntaje) {

        return (puntaje * factor);
    }

}

