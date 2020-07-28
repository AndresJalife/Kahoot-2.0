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
        Opcion Verdadero = new Opcion("Verdadero", true);
        Opcion Falso = new Opcion("Falso");

        opciones.add(Verdadero);
        opciones.add(Falso);

        Pregunta pregunta = new Pregunta("2 + 2 = 4", opciones, 1, 1, new TipoVerdaderoYFalso(), new ModoConPenalidad());

        assertEquals(new Opcion[]{opciones.get(0)}, pregunta.obtenerRespuestasCorrectas());
    }


    @Test
    public void ingresarListaRespuestasYAsignarPuntosAJugadorYContestaBien() {
        List<Opcion> opciones = new ArrayList<>();
        Jugador jugador = new Jugador("Mathias");

        Opcion Verdadero = new Opcion("Verdadero", true);
        Opcion Falso = new Opcion("Falso");

        opciones.add(Verdadero);
        opciones.add(Falso);

        var respuestasJugador = new int[]{0};
        var pregunta = new Pregunta("2 + 2 = 4", opciones, 1, 1, new TipoVerdaderoYFalso(), new ModoConPenalidad());

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestasJugador));

        assertEquals(1, jugador.obtenerPuntaje());
    }

    @Test
    public void ingresarListaRespuestasYAsignarPuntosAJugadorYContestaMal() {
        List<Opcion> opciones = new ArrayList<>();
        Jugador jugador = new Jugador("Mathias");

        Opcion Verdadero = new Opcion("Verdadero", true);
        Opcion Falso = new Opcion("Falso");

        opciones.add(Verdadero);
        opciones.add(Falso);

        var respuestasJugador = new int[]{1};
        var pregunta = new Pregunta("2 + 2 = 4", opciones, 1, 1, new TipoVerdaderoYFalso(), new ModoConPenalidad());

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestasJugador));

        assertEquals(-1, jugador.obtenerPuntaje());
    }

}
