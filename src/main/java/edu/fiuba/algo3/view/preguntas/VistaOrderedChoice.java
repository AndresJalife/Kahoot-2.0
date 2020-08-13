package edu.fiuba.algo3.view.preguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.general.RespuestasPorJugador;

public class VistaOrderedChoice extends VistaTipoDePregunta {
    private RespuestasPorJugador respuestasPorJugador;
    public VistaOrderedChoice(RespuestasPorJugador respuestasPorJugador){
        this.respuestasPorJugador = respuestasPorJugador;

    }

    public VistaOrderedChoice(Kahoot modelo, Jugador jugador) {
    }
}
