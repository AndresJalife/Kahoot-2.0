package edu.fiuba.algo3.modelo.general;

public class Multiplicadorx3 extends Multiplicador {

    private final static int factor = 3;

    @Override
    public int modificarPuntaje(int puntaje){
        return (puntaje * factor);
    }


    private int Cantidad; //Hardcodeo para pruebas de Jugador
    public int getCantidad(){ return Cantidad; } //Hardcodeo para pruebas de Jugador
}
