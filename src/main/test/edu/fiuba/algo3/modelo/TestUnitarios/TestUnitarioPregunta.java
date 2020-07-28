package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.preguntas.ModoClasico;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.TipoVerdaderoYFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnitarioPregunta {

    @Test
    public void TestPreguntaDevuelveCorrectamenteLasRespuestasCorrectas() {
        var opciones = Arrays.asList(
                new Opcion("Opcion1"),
                new Opcion("Opcion2", true)
        );
        var pregunta = new Pregunta("¿Cual es la correcta?", opciones, 1, 1, new TipoVerdaderoYFalso(), new ModoClasico());
        assertEquals(new Opcion[]{opciones.get(1)}, pregunta.obtenerRespuestasCorrectas());
    }

    @Test
    public void TestPreguntaDevuelveCorrectamenteLasOpciones() {
        var opciones = Arrays.asList(
                new Opcion("Opcion1"),
                new Opcion("Opcion2", true)
        );
        var pregunta = new Pregunta("¿Cual es la correcta?", opciones, 1, 1, new TipoVerdaderoYFalso(), new ModoClasico());
        assertEquals(opciones.toArray(Opcion[]::new), pregunta.obtenerOpciones());
    }

    @Test
    public void TestPreguntaCalculaElPuntajeCorrectamente() {
        var opciones = Arrays.asList(
                new Opcion("Opcion1"),
                new Opcion("Opcion2", true)
        );
        var puntajePorRespuesta = 5;
        var pregunta = new Pregunta("¿Cual es la correcta?", opciones, 1, puntajePorRespuesta, new TipoVerdaderoYFalso(), new ModoClasico());
        assertEquals(5, pregunta.calcularPuntaje(new int[] {1}));
    }

}
