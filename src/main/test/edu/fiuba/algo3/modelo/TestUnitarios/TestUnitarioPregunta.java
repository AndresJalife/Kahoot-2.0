package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.preguntas.ModoClasico;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.TipoVerdaderoYFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnitarioPregunta {

    @Test
    public void TestPreguntaDevuelveCorrectamenteLasRespuestasCorrectas() {
        Opcion opcion1 = new Opcion("Opcion1");
        Opcion opcion2 = new Opcion("Opcion", true);
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opcionesCorrectas.add(opcion2);

        var pregunta = new Pregunta("¿Cual es la correcta?", opciones, new TipoVerdaderoYFalso(), new ModoClasico());
        assertEquals(opcionesCorrectas, pregunta.obtenerRespuestasCorrectas());
    }

    @Test
    public void TestPreguntaDevuelveCorrectamenteLasOpciones() {
        Opcion opcion1 = new Opcion("Opcion1");
        Opcion opcion2 = new Opcion("Opcion2", true);
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        var pregunta = new Pregunta("¿Cual es la correcta?", opciones, new TipoVerdaderoYFalso(), new ModoClasico());
        assertEquals(opciones, pregunta.obtenerOpciones());
    }

    @Test
    public void TestPreguntaCalculaElPuntajeCorrectamente() {
        Opcion opcion1 = new Opcion("Opcion1");
        Opcion opcion2 = new Opcion("Opcion2", true);
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesContestadas = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opcionesContestadas.add(opcion2);

        var pregunta = new Pregunta("¿Cual es la correcta?", opciones, new TipoVerdaderoYFalso(), new ModoClasico());
        assertEquals(1, pregunta.calcularPuntaje(opcionesContestadas));
    }

}
