package edu.fiuba.algo3.modelo.TestUnitarios.TestsPreguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsUnitariosVerdaderoFalsoClasico {

    @Test
    public void ingresarRespuestaVerdaderoFalsoClasico() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");

        opciones.add(Opcion1);
        opciones.add(Opcion2);

        Pregunta pregunta = new Pregunta("Francia es un pais", opciones, new TipoMultipleChoice(), new ModoClasico());
        respuestas.add(Opcion1);

        assertEquals(respuestas, pregunta.obtenerRespuestasCorrectas());
    }

    @Test
    public void ingresarRespuestaVerdaderoFalsoClasicoYContestaBien() {
        List<Opcion> opciones = new ArrayList<>();
        List<RespuestaDeJugador> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");

        opciones.add(Opcion1);
        opciones.add(Opcion2);

        Pregunta pregunta = new Pregunta("Francia es un pais", opciones, new TipoMultipleChoice(), new ModoClasico());
        respuestas.add(new RespuestaDeJugador(Opcion1));

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(1, jugador.obtenerPuntaje());
    }

    @Test
    public void ingresarRespuestaVerdaderoFalsoClasicoYContestaMal() {
        List<Opcion> opciones = new ArrayList<>();
        List<RespuestaDeJugador> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");

        opciones.add(Opcion1);
        opciones.add(Opcion2);

        Pregunta pregunta = new Pregunta("Francia es un pais", opciones, new TipoMultipleChoice(), new ModoClasico());
        respuestas.add(new RespuestaDeJugador(Opcion2));

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(0, jugador.obtenerPuntaje());
    }
}
