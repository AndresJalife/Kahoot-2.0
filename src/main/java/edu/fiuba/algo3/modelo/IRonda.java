package edu.fiuba.algo3.modelo;

public interface IRonda {
    void agregarExclusividad(Jugador jugador, Exclusividad exclusividad) throws MultiplicadorEnRondaExclusivaError;
    void agregarMultiplicador(Jugador jugador, Multiplicador multiplicador) throws ExclusividadEnRondaNormalError;
    void actualizar(Jugador jugador);
    void comenzar();
    void mostrarPregunta();
    void pedirRespuesta(Jugador jugador);
    void mostrarRespuestaCorrecta();
    void mostrarPosiblesRespuestas();
    void mostrarModificadores(Jugador jugador);
}
