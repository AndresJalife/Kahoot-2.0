package edu.fiuba.algo3.modelo.TestUnitarios.TestsPreguntas;


import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsUnitariosMultipleChoiceConParcialTest {

    @Test
    public void ingresarRespuestaMultipleChoiceConParcial() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        var Opcion1 = new Opcion("Si", true);
        var Opcion2 = new Opcion("No");
        var Opcion3 = new Opcion("Si, es correcta", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        var pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoPuntajeParcial());
        respuestas.add(Opcion1);
        respuestas.add(Opcion3);

        assertEquals(respuestas, pregunta.obtenerRespuestasCorrectas());
    }

    @Test
    public void ingresarRespuestaMultipleChoiceConParcialYContestaBien() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");
        Opcion Opcion3 = new Opcion("Si, es correcta", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        var pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoPuntajeParcial());
        respuestas.add(Opcion1);
        respuestas.add(Opcion3);

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(2, jugador.obtenerPuntaje());
    }

    @Test
    public void ingresarRespuestaMultipleChoiceYContestaParcialmenteBien() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");
        Opcion Opcion3 = new Opcion("Si, es correcta", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        var pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoPuntajeParcial());
        respuestas.add(Opcion1);

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(1, jugador.obtenerPuntaje());
    }

    @Test
    public void ingresarRespuestaMultipleChoiceClasicoYContestaMal() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");
        Opcion Opcion3 = new Opcion("Si, es correcta", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        var pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoPuntajeParcial());

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(0, jugador.obtenerPuntaje());
    }
}