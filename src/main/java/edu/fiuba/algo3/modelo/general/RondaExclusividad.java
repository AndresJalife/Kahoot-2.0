package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RondaExclusividad extends RondaBase {
    private List<Exclusividad> exclusividades;

    public RondaExclusividad(Pregunta pregunta, List<Jugador> jugadores) {
        super(pregunta, jugadores);
        exclusividades = new ArrayList<>();
    }

    @Override
    public List<IModificador> obtenerModificadores(Jugador jugador) {
        Exclusividad exclusividad = jugador.obtenerExclusividades();
        List<IModificador> exclusividadRestante = new ArrayList<IModificador>();
        if (exclusividad.quedanUsos()){
            exclusividadRestante.add(exclusividad);
        }
        return exclusividadRestante;
    }

    @Override
    public void actualizarPuntaje() throws NoQuedanUsosExcepcion {
        var puntajesPorJugador = new HashMap<Jugador, Integer>();
        var hayExclusividad = exclusividades.size() > 0;
        Jugador ganador = null;
        
        for (Jugador jugador : jugadores){
            var respuestas = respuestasDeJugadores.get(jugador);
            int puntajeActual = this.preguntaActual.calcularPuntaje(respuestas);
            if (puntajeActual > 0){
                ganador = jugador;
                puntajesPorJugador.put(jugador, puntajeActual);
            }
        }

        if (hayExclusividad) {
            if (puntajesPorJugador.size() == 1) {
                int puntajeFinal = 0;
                for (Exclusividad exclusividad : exclusividades) {
                    if (exclusividad.quedanUsos()) {
                        puntajeFinal += exclusividad.modificarPuntaje(puntajesPorJugador.get(jugadores));
                    }
                }
                ganador.agregarPuntaje(puntajeFinal);
            }
        } else {
            for(var jugador : puntajesPorJugador.keySet()) {
                jugador.agregarPuntaje(puntajesPorJugador.get(jugador));
            }
        }
    }
}
