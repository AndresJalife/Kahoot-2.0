package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.HashMap;
import java.util.List;

public class RondaNormal extends RondaBase {

    private HashMap<Jugador, Multiplicador> multiplicadores;

    public RondaNormal(Pregunta pregunta, List<Jugador> nuevosJugadores) {
        super(pregunta, nuevosJugadores);
    }

    @Override
    public void mostrarModificadores(Jugador jugador) {
        Multiplicadorx2 x2 = jugador.obtenerMultiplicadorX2();
        Multiplicadorx3 x3 = jugador.obtenerMultiplicadorX3();
        if (x2.quedanUsos()){
            System.out.println("X2");
        }
        if (x3.quedanUsos()){
            System.out.println("X3");
        }
    //        MOSTRAR POR PANTALLA BOTONES MULTIPLICADORES Y QUE APRIETE SOLO 1
    //        HAY QUE AGREGARLOS AL DICCIONARIO DE MULTIPLICADORES ACTUALES
    }

    public void actualizar(Jugador jugador) {
        var respuestas = respuestasDeJugadores.get(jugador);

        int puntaje = this.preguntaActual.calcularPuntaje(respuestas);
        puntaje = (multiplicadores.get(jugador)).modificarPuntaje(puntaje);
        jugador.agregarPuntaje(puntaje);
    }

    @Override
    public void comenzar() {
        for (Jugador jugador:jugadores) {
            this.mostrarPregunta();
            this.mostrarModificadores(jugador);
            this.mostrarPosiblesRespuestas();
            this.pedirRespuesta(jugador);
            this.actualizar(jugador);
        }
        this.mostrarRespuestaCorrecta();
    }

}