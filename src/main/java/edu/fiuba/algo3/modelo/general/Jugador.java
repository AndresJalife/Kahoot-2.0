package edu.fiuba.algo3.modelo.general;

public class Jugador {

    private int puntaje;
    private String nombre;
    private Multiplicador x2;
    private Multiplicador x3;
    private Exclusividad exclusividades;

    public Jugador(String nombre) {
        this.nombre = nombre;
        exclusividades = new Exclusividad(2);
        x3 = new Multiplicador(3);
        x2 = new Multiplicador(2);
    }
    public Multiplicador obtenerMultiplicadorX2() {
        return x2;
    }

    public Multiplicador obtenerMultiplicadorX3() {
        return x3;
    }

    public Exclusividad obtenerExclusividades() {
        return exclusividades;
    }

    public int obtenerPuntaje() {
        return this.puntaje;
    }

    public void agregarPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

}
