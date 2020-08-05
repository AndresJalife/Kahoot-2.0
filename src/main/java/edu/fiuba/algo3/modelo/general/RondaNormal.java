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

    @Override
    public void actualizarPuntaje() throws NoQuedanUsosExcepcion {
        for (var jugador: jugadores) {
            var respuestas = respuestasDeJugadores.get(jugador);
            int puntaje = this.preguntaActual.calcularPuntaje(respuestas);

            Multiplicador multActual = (multiplicadores.get(jugador));
            if (multActual.quedanUsos()) {
                puntaje = multActual.modificarPuntaje(puntaje);
            }
            jugador.agregarPuntaje(puntaje);
        }
    }
}