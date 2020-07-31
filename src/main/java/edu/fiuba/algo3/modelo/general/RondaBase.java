package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.HashMap;
import java.util.List;

public abstract class RondaBase {
    protected Pregunta preguntaActual;
    protected List<Jugador> jugadores;
    protected HashMap<Jugador, List<Opcion>> respuestasDeJugadores;

    public RondaBase(Pregunta pregunta, List<Jugador> nuevosJugadores){
        preguntaActual = pregunta;
        jugadores = nuevosJugadores;
        respuestasDeJugadores = new HashMap<>();
    }

    public Pregunta obtenerPreguntaActual() {
        return preguntaActual;
    }

    public void pedirRespuesta(Jugador jugador) {
        //respuestasDeJugadores.put(jugador, input(Opcion opcion));
//        CORREGIR EL INPUT
    }

    public List<Opcion> obtenerRespuestasCorrectas(){
        return preguntaActual.obtenerRespuestasCorrectas();
    }

    public List<Opcion> obtenerPosiblesRespuestas() {
        return preguntaActual.obtenerOpciones();
    }

    public abstract List<String> obtenerModificadores(Jugador jugador);
    public abstract void comenzar();
}
