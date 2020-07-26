package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class RondaNormal implements IRonda {
    private Pregunta preguntaActual;
    private List<IModificador> multiplicadores;

    public void RondaExclusividad(Pregunta pregunta){
        preguntaActual = pregunta;
        multiplicadores = new ArrayList<>();
    }

    @Override
    public void agregarExclusividad(IModificador exclusividad) throws MultiplicadorEnRondaExclusivaError {
        throw new MultiplicadorEnRondaExclusivaError();
    }

    @Override
    public void agregarMultiplicador(IModificador multiplicador){multiplicadores.add(multiplicador);}

    @Override
    public void actualizar(Jugador jugador) {
        List<Opcion> respuestas = jugador.getRespuestas();

        int puntaje = this.preguntaActual.calcularPuntaje(respuestas);

        jugador.agregarPuntaje(puntaje);
    }
}
