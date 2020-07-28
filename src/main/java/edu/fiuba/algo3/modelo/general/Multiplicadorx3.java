package edu.fiuba.algo3.modelo.general;

public class Multiplicadorx3 extends Multiplicador {

    private final int factor = 3;

    @Override
    public int modificarPuntaje(int puntaje){

        return (puntaje * factor);
    }

}
