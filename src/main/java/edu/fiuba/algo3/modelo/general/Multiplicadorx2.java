package edu.fiuba.algo3.modelo.general;

public class Multiplicadorx2 extends Multiplicador {

    private final static int factor = 2;

    @Override
    public int modificarPuntaje(int puntaje) {
        return (puntaje * factor);
    }


    private int Cantidad; //Hardcodeado test jugador
    public static int CondicionesIniciales = 2; //Hardcodeado test jugador
    public int getCantidad(){ return Cantidad; } //Hardcodeado test jugador

}

