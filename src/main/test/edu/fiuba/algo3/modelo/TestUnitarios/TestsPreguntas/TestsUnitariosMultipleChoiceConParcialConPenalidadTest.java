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
        var Opcion1 = new Opcion("Si", true);
        var Opcion2 = new Opcion("No");
        var Opcion3 = new Opcion("Si, es correcta", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        var pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoPuntajeParcialConPenalidad());
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

        var pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoPuntajeParcialConPenalidad());
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

        var pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoPuntajeParcialConPenalidad());
        respuestas.add(Opcion1);

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(1, jugador.obtenerPuntaje());
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

        var pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoPuntajeParcialConPenalidad());

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(-1, jugador.obtenerPuntaje());
    }
}
