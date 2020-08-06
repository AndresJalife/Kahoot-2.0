package edu.fiuba.algo3.modelo.preguntas;

import java.util.List;

public interface ITipoDePregunta {
    boolean opcionesValidas(List<Opcion> opciones);
    int cantCorrectas(List<Opcion> opciones, List<Opcion> respuestasJugador);
    int cantIncorrectas(List<Opcion> opciones,List<Opcion> respuestasJugador);

}
