package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RondaNormal extends RondaBase {

    private HashMap<Jugador, Multiplicador> multiplicadores;

    public RondaNormal(Pregunta pregunta, List<Jugador> nuevosJugadores) {
        super(pregunta, nuevosJugadores);
    }

    @Override
    public List<String> obtenerModificadores(Jugador jugador) {
        Multiplicador x2 = jugador.obtenerMultiplicadorX2();
        Multiplicador x3 = jugador.obtenerMultiplicadorX3();
        List<String> multiplicadoresRestantes = new ArrayList<String>();

        if (x2.quedanUsos()){
            multiplicadoresRestantes.add("X2");
        }
        if (x3.quedanUsos()){
            multiplicadoresRestantes.add("X3");
        }
        return multiplicadoresRestantes;
    }

    public void actualizar(Jugador jugador) {
        var respuestas = respuestasDeJugadores.get(jugador);

        int puntaje = this.preguntaActual.calcularPuntaje(respuestas);
        puntaje = (multiplicadores.get(jugador)).modificarPuntaje(puntaje);
        jugador.agregarPuntaje(puntaje);
    }

    @Override
    public void comenzar(){
        for (Jugador jugador:jugadores) {
//            this.obtenerPreguntaActual();
//            this.obtenerModificadores(jugador);
//            this.obtenerPosiblesRespuestas();
//            panel.mostrarPreguntaActual()/
//            panel.mostrarModificadores(jugador);
//            panel.mostrarPosiblesRespuestas();

            this.pedirRespuesta(jugador);
            this.actualizar(jugador);
        }
//        this.obtenerRespuestasCorrectas();
//        panel.mostrarRespuestasCorrectas()
    }

}