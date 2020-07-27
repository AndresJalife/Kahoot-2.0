package edu.fiuba.algo3.modelo;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class Jugador {

    private List<Opcion> respuestas;
    private int puntaje;
    private String nombre;
    private MultiplicadorX2 x2;
    private MultiplicadorX3 x3;
    private Exclusividad exclusividades;

    public Jugador(String nombre)
    {
        this.nombre = nombre;
        modificadores = new HashMap<>();
        exclusividades = new Exclusividad();
        x3 = new MultiplicadorX3();
        x2 = new MultiplicadorX2();
    }
    public MultiplicadorX2 obtenerMultiplicadorX2(){
        return x2;
    }

    public MultiplicadorX3 obtenerMultiplicadorX3(){
        return x3;
    }

    public Exclusividad obtenerExclusividades(){
        return exclusividades;
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
