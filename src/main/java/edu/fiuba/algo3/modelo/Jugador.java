package edu.fiuba.algo3.modelo;

import java.util.List;

public class Jugador {

    private List<Opcion> respuestas;
    private int puntaje;
    private String nombre;

    public Jugador(String nombre)
    {
        this.nombre = nombre;
    }

    public void agregarRespuestas(List<Opcion> respuestas)
    {
        this.respuestas = respuestas;
    }

    public int obtenerPuntaje()
    {
        return this.puntaje;
    }

    public List<Opcion> getRespuestas()
    {
        return this.respuestas;
    }

    public void agregarPuntaje(int puntaje)
    {
        this.puntaje = puntaje;
    }
}
