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

    public void guardarRespuestas(Jugador jugador, List<Opcion> respuestas) {
        respuestasDeJugadores.put(jugador, respuestas);
    }

    public List<Opcion> obtenerRespuestasCorrectas(){
        return preguntaActual.obtenerRespuestasCorrectas();
    }

    public List<Opcion> obtenerPosiblesRespuestas() {
        return preguntaActual.obtenerOpciones();
    }

    public abstract List<String> obtenerModificadores(Jugador jugador);

    public abstract void actualizarPuntaje() throws NoQuedanUsosExcepcion;

    public void comenzar() {
        /*for (Jugador jugador:jugadores) {
//            panel.mostrarPreguntaActual()/
//            panel.mostrarModificadores(jugador);
//            panel.mostrarPosiblesRespuestas();
        }
        try {
            this.actualizarPuntaje();
        }catch (NoQuedanUsosExcepcion except) {
//            MANEJAR LA EXCEPCIÓN
        }*/

//        panel.mostrarRespuestasCorrectas()
    }
}
