package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoPenalidadTest {

    @Test
    public void ingresarRespuestaVerdaderoFalsoPenalidad() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Opcion Verdadero = new Opcion("Verdadero");
        Opcion Falso = new Opcion("Falso");

        respuestas.add(Verdadero);

        opciones.add(Verdadero);
        opciones.add(Falso);

        Pregunta pregunta = new Pregunta("2 + 2 = 4", opciones, 1, 1, new TipoVerdaderoYFalso(), new ModoConPenalidad());

        assertEquals(respuestas, pregunta.obtenerRespuestasCorrectas());
    }


    @Test
    public void ingresarListaRespuestasYAsignarPuntosAJugadorYContestaBien() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestasJugador = new ArrayList<>();
        Jugador jugador = new Jugador("Mathias");
        Opcion Verdadero = new Opcion("Verdadero", true);
        Opcion Falso = new Opcion("Falso");

        opciones.add(Verdadero);
        opciones.add(Falso);
        respuestasJugador.add(Verdadero);

        Pregunta pregunta = new Pregunta("2 + 2 = 4", opciones, 1, 1, new TipoVerdaderoYFalso(), new ModoConPenalidad());

        jugador.agregarRespuestas(respuestasJugador);
        jugador.agregarPuntaje(pregunta.calcularPuntaje(jugador.getRespuestas()));

        assertEquals(1, jugador.obtenerPuntaje());
    }

    @Test
    public void ingresarListaRespuestasYAsignarPuntosAJugadorYContestaMal() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestasJugador = new ArrayList<>();
        Jugador jugador = new Jugador("Mathias");
        Opcion Verdadero = new Opcion("Verdadero");
        Opcion Falso = new Opcion("Falso");
        Verdadero.Opcion_Correcta();

        opciones.add(Verdadero);
        opciones.add(Falso);
        respuestasJugador.add(Verdadero);

        Pregunta pregunta = new Pregunta("2 + 2 = 4", opciones, ITipoDePregunta.VerdaderoFalso, IModoDePregunta.Penalidad);

        jugador.agregarRespuestas(respuestasJugador);
        jugador.agregarPuntaje(pregunta.calcularPuntaje(jugador.getRespuestas()));

        assertEquals(-1, jugador.obtenerPuntaje());
    }

}
