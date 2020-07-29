package edu.fiuba.algo3.modelo.TestUnitarios.TestsPreguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.preguntas.ModoClasico;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.TipoMultipleChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsUnitariosVerdaderoFalsoClasico {

    @Test
    public void ingresarRespuestaVerdaderoFalsoClasico() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        var Opcion1 = new Opcion("Si", true);
        var Opcion2 = new Opcion("No");

        opciones.add(Opcion1);
        opciones.add(Opcion2);

        var pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoClasico());
        respuestas.add(Opcion1);

        assertEquals(respuestas, pregunta.obtenerRespuestasCorrectas());
    }

    @Test
    public void ingresarRespuestaVerdaderoFalsolasicoYContestaBien() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");

        opciones.add(Opcion1);
        opciones.add(Opcion2);

        var pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoClasico());
        respuestas.add(Opcion1);

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(1, jugador.obtenerPuntaje());
    }

    @Test
    public void ingresarRespuestaVerdaderoFalsolasicoYContestaMal() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");

        opciones.add(Opcion1);
        opciones.add(Opcion2);

        var pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoClasico());
        respuestas.add(Opcion2);

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(0, jugador.obtenerPuntaje());
    }
}
