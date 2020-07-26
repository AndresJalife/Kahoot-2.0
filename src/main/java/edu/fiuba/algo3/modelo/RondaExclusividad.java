package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class RondaExclusividad implements IRonda {
    private Pregunta preguntaActual;
    private List<IModificador> exclusividades;

    public void RondaExclusividad(Pregunta pregunta){
        preguntaActual = pregunta;
        exclusividades = new ArrayList<>();
    }

    @Override
    public void agregarExclusividad(IModificador modificador){exclusividades.add(modificador);}

    @Override
    public void agregarMultiplicador(IModificador modificador) throws ExclusividadEnRondaNormalError {
        throw new ExclusividadEnRondaNormalError();
    }

    @Override
    public void actualizar(Jugador jugador){
        List<Opcion> respuestas = jugador.getRespuestas();

        int puntaje = this.preguntaActual.calcularPuntaje(respuestas);

        jugador.agregarPuntaje(puntaje);
    }
}
