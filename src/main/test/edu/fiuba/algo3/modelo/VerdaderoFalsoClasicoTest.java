package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoClasicoTest {

    @Test
    public void ingresarRespuestaVerdaderoFalsoClasico() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Opcion Verdadero = new Opcion("Verdadero");
        Opcion Falso = new Opcion("Falso");
        Verdadero.Opcion_Correcta();
        respuestas.add(Verdadero);

        opciones.add(Verdadero);
        opciones.add(Falso);

        Pregunta pregunta = new Pregunta("2 + 2 = 4", opciones, ITipoDePregunta.VerdaderoFalso, IModoDePregunta.Clasico);

        assertEquals(respuestas, pregunta.getRespuesta());
    }


    @Test
    public void ingresarListaRespuestasYAsignarPuntosAJugador() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestasJugador = new ArrayList<>();
        Jugador jugador = new Jugador("Mathias");
        Opcion Verdadero = new Opcion("Verdadero");
        Opcion Falso = new Opcion("Falso");
        Verdadero.Opcion_Correcta();

        opciones.add(Verdadero);
        opciones.add(Falso);
        respuestasJugador.add(Verdadero);

        Pregunta pregunta = new Pregunta("2 + 2 = 4", opciones, ITipoDePregunta.VerdaderoFalso, IModoDePregunta.Clasico);

        jugador.agregarRespuestas(respuestasJugador);
        jugador.agregarPuntaje(pregunta.calcularPuntaje(jugador.getRespuestas()));

        assertEquals(1, jugador.obtenerPuntaje());
    }


}