package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoClasicoTest {

    @Test
    public void ingresarRespuestaVerdaderoFalsoClasico() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Opcion Verdadero = new Opcion("Verdadero", true);
        Opcion Falso = new Opcion("Falso");

        opciones.add(Verdadero);
        opciones.add(Falso);
        respuestas.add(Verdadero);

        Pregunta pregunta = new Pregunta("2 + 2 = 4", opciones, 1, 1, new TipoVerdaderoYFalso(), new ModoClasico());

        assertEquals(respuestas, pregunta.obtenerRespuestasCorrectas());
    }

    @Test
    public void ingresarListaRespuestasYAsignarPuntosAJugadorYContestaMal() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesContestadas = new ArrayList<>();
        Jugador jugador = new Jugador("Mathias");

        Opcion Verdadero = new Opcion("Verdadero", true);
        Opcion Falso = new Opcion("Falso");

        opciones.add(Verdadero);
        opciones.add(Falso);
        opcionesContestadas.add(Falso);

        var respuestasJugador = new int[]{1};
        var pregunta = new Pregunta("2 + 2 = 4", opciones, 1, 1, new TipoVerdaderoYFalso(), new ModoClasico());

        jugador.agregarPuntaje(pregunta.calcularPuntaje(opcionesContestadas));

        assertEquals(0, jugador.obtenerPuntaje());
    }



}