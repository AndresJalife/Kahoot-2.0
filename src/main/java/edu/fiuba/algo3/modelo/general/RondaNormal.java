package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RondaNormal extends RondaBase {

    private HashMap<Jugador, Multiplicador> multiplicadores;

    public RondaNormal(Pregunta pregunta, List<Jugador> nuevosJugadores) {
        super(pregunta, nuevosJugadores);
        multiplicadores = new HashMap<>();
    }

    @Override
    public List<IModificador> obtenerModificadores(Jugador jugador) {
        var x2 = jugador.obtenerMultiplicadorX2();
        var x3 = jugador.obtenerMultiplicadorX3();
        List<IModificador> multiplicadoresRestantes = new ArrayList<IModificador>();

        if (x2.quedanUsos()){
            multiplicadoresRestantes.add(x2);
        }
        if (x3.quedanUsos()){
            multiplicadoresRestantes.add(x3);
        }
        return multiplicadoresRestantes;
    }

    @Override
    public void usarModificador(Jugador jugador, IModificador modificador) {
        multiplicadores.put(jugador, (Multiplicador) modificador);
    }

    @Override
    public void actualizarPuntaje() throws NoQuedanUsosExcepcion {
        for (var jugador: jugadores) {
            var respuestas = respuestasDeJugadores.get(jugador);
            int puntaje = this.preguntaActual.calcularPuntaje(respuestas);

            Multiplicador multActual = (multiplicadores.get(jugador));
            if (multActual != null && multActual.quedanUsos()) {
                puntaje = multActual.modificarPuntaje(puntaje);
            }
            jugador.agregarPuntaje(puntaje);
        }
    }
}