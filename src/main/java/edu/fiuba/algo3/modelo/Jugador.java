package edu.fiuba.algo3.modelo;

import java.util.List;

public class Jugador {

    private List<String> respuestas;
    private int puntaje;
    private String nombre;

    public Jugador(String nombre)
    {
        this.nombre = nombre;
    }

    public void agregarRespuestas(List<String> respuestas)
    {
        this.respuestas = respuestas;
    }

    public int obtenerPuntaje()
    {
        return this.puntaje;
    }

    public List<String> getRespuestas()
    {
        return this.respuestas;
    }

    public void agregarPuntaje(int puntaje)
    {
        this.puntaje = puntaje;
    }
}
