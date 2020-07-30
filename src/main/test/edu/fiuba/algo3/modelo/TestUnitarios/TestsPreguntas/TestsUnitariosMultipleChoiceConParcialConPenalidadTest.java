package edu.fiuba.algo3.modelo.TestUnitarios.TestsPreguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsUnitariosMultipleChoiceConParcialConPenalidadTest {
    @Test
    public void ingresarRespuestaMultipleChoiceConPuntajeParcialYPenalidad() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");
        Opcion Opcion3 = new Opcion("Si, es correcta", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        Pregunta pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoConPenalidad());
        respuestas.add(Opcion1);
        respuestas.add(Opcion3);

        assertEquals(respuestas, pregunta.obtenerRespuestasCorrectas());
    }

    @Test
    public void ingresarRespuestaMultipleChoiceConPuntajeParcialYPenalidadYContestaBien() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");
        Opcion Opcion3 = new Opcion("Si, es correcta", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        Pregunta pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoConPenalidad());
        respuestas.add(Opcion1);
        respuestas.add(Opcion3);

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(2, jugador.obtenerPuntaje());
    }

    @Test
    public void ingresarRespuestaMultipleChoiceConPuntajeParcialYPenalidadYContestaParcialmenteBien() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");
        Opcion Opcion3 = new Opcion("Si, es correcta", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        Pregunta pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoConPenalidad());
        respuestas.add(Opcion1);

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(1, jugador.obtenerPuntaje());
    }

    @Test
    public void ingresarRespuestaMultipleChoiceConPuntajeParcialYPenalidadYContestaUnaBienYUnaMal() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");
        Opcion Opcion3 = new Opcion("Si, es correcta", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        Pregunta pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoConPenalidad());
        respuestas.add(Opcion1);
        respuestas.add(Opcion2);

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(0, jugador.obtenerPuntaje());
    }

    @Test
    public void ingresarRespuestaMultipleChoiceConPuntajeParcialYPenalidadYContestaMal() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");
        Opcion Opcion3 = new Opcion("Si, es correcta", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);
        respuestas.add(Opcion2);

        Pregunta pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoConPenalidad());

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(-1, jugador.obtenerPuntaje());
    }

    @Test
    public void ingresarRespuestaMultipleChoiceConPuntajeParcialYPenalidadYContestaDosMal() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");
        Opcion Opcion3 = new Opcion("Si, es correcta", true);
        Opcion Opcion4 = new Opcion("No, es falso");

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);
        opciones.add(Opcion4);
        respuestas.add(Opcion2);
        respuestas.add(Opcion4);

        Pregunta pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoConPenalidad());

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(-2, jugador.obtenerPuntaje());
    }
}
