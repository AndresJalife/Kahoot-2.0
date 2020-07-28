package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.HashMap;
import java.util.List;

public class RondaExclusividad extends RondaNormal {
    private HashMap<Jugador, Exclusividad> exclusividades;

    public RondaExclusividad(Pregunta pregunta, List<Jugador> jugadores) {

        super(pregunta, jugadores);
    }

}
