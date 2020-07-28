package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Opcion;

import java.util.HashMap;
import java.util.List;

public class Jugador {

    private int puntaje;
    private String nombre;
    private Multiplicadorx2 x2;
    private Multiplicadorx3 x3;
    private Exclusividad exclusividades;

    public Jugador(String nombre)
    {
        this.nombre = nombre;
        exclusividades = new Exclusividad();
        x3 = new Multiplicadorx3();
        x2 = new Multiplicadorx2();
    }
    public Multiplicadorx2 obtenerMultiplicadorX2() {
        return x2;
    }

    public Multiplicadorx3 obtenerMultiplicadorX3() {
        return x3;
    }

    public Exclusividad obtenerExclusividades() {
        return exclusividades;
    }

    public int obtenerPuntaje() {
        return this.puntaje;
    }

    public void agregarPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
