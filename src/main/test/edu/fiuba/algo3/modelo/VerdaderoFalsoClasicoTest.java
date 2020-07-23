package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoClasicoTest {

    @Test
    public void ingresarRespuestaVerdaderoFalsoClasico() {
        List<String> opciones = new ArrayList<>();
        List<String> respuestas = new ArrayList<>();

        opciones.add("Verdadero");
        opciones.add("Falso");
        respuestas.add("Verdadero");

        Pregunta pregunta = new Pregunta("2 + 2 = 4", opciones, respuestas, ITipoDePregunta.VerdaderoFalso, IModoDePregunta.Clasico);

        assertEquals(respuestas, pregunta.getRespuesta());
    }


    @Test
    public void ingresarListaRespuestasYAsignarPuntosAJugador() {
        List<String> opciones = new ArrayList<>();
        List<String> respuestas = new ArrayList<>();
        List<String> respuestasJugador = new ArrayList<>();
        Jugador jugador = new Jugador("Mathias");

        opciones.add("Verdadero");
        opciones.add("Falso");
        respuestas.add("Verdadero");
        respuestasJugador.add("Falso");

        Pregunta pregunta = new Pregunta("2 + 2 = 4", opciones, respuestas, ITipoDePregunta.VerdaderoFalso, IModoDePregunta.Clasico);

        jugador.agregarRespuestas(respuestasJugador);
        jugador.agregarPuntaje(pregunta.calcularPuntaje(jugador.getRespuestas()));

        assertEquals(0, jugador.obtenerPuntaje());
    }


}