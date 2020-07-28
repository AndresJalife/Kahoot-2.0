package edu.fiuba.algo3.modelo;

public class Multiplicadorx3 extends Multiplicador {


    private int Cantidad; //Hardcodeo para pruebas de Jugador

    public int getCantidad(){ return Cantidad; } //Hardcodeo para pruebas de Jugador


    private static int factor=3;

    public int obtenerFactor(){
        return factor;
    }
}
