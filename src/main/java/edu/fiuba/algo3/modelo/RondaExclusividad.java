package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RondaExclusividad extends RondaNormal {
    private HashMap<Jugador, Exclusividad> exclusividades;

    public RondaExclusividad(Pregunta pregunta, List<Jugador> jugadores) {
        super(pregunta, jugadores);
    }

    @Override
    public void agregarExclusividad(Jugador jugador, Exclusividad modificador) throws MultiplicadorEnRondaExclusivaError {
        exclusividades.put(jugador, modificador);
    }

    @Override
    public void agregarMultiplicador(Jugador jugador, Multiplicador modificador) throws ExclusividadEnRondaNormalError {
        throw new ExclusividadEnRondaNormalError();
    }
}
