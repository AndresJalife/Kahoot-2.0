package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class RondaExclusividad implements IRonda {
    private Pregunta preguntaActual;
    private List<IModificador> exclusividades;

    public RondaExclusividad(Pregunta pregunta, List<Jugador> jugadores){
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

    public void comenzar(){
        this.mostrarPregunta();
        this.mostrarModificadores();
        this.pedirRespuesta();
        this.mostrarRespuesta();
    }
}
