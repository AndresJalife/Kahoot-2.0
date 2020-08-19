package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.lectorDeArchivos.LectorDeArchivosJson;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class TestsUnitariosLectorDeArchivosJson {
    LectorDeArchivosJson lectorDeArchivosJson = new LectorDeArchivosJson();

    @Test
    public void cargoUnaPreguntaMultipleChoiceYSeCreaCorrectamente() throws IOException, ParseException {
        List<Pregunta> preguntas = lectorDeArchivosJson.crearListaDePreguntas(Paths.get("src/main/resources/preguntaMultiple.json").toAbsolutePath().toUri());

        Pregunta pregunta = preguntas.get(0);
        assertEquals(pregunta.obtenerTexto(), "¿Quién gano gran hermano 2015?");
        assertEquals(pregunta.obtenerTipo().getClass(), TipoMultipleChoice.class);
        assertEquals(pregunta.getClass(),Pregunta.class);

    }

    @Test
    public void cargoUnaPreguntaVerdaderoYFalsoYSeCreaCorrectamente() throws IOException, ParseException {
        List<Pregunta> preguntas = lectorDeArchivosJson.crearListaDePreguntas(Paths.get("src/main/resources/preguntasVyF.json").toAbsolutePath().toUri());

        Pregunta pregunta = preguntas.get(0);
        assertEquals(pregunta.obtenerTexto(), "¿Era Abraham Lincoln un asesino?");
        assertEquals(pregunta.obtenerTipo().getClass(), TipoVerdaderoYFalso.class);
        assertEquals(pregunta.getClass(),Pregunta.class);
        assertEquals(pregunta.obtenerRespuestasCorrectas().get(0).obtenerTexto(), "Verdadero");

    }

    @Test
    public void cargoUnaPreguntaGroupChoiceYSeCreaCorrectamente() throws IOException, ParseException {
        List<Pregunta> preguntas = lectorDeArchivosJson.crearListaDePreguntas(Paths.get("src/main/resources/groupChoice.json").toAbsolutePath().toUri());

        Pregunta pregunta = preguntas.get(0);
        assertEquals(pregunta.obtenerTexto(), "Separe entre caballos (Grupo 1) y flores (Grupo 2).");
        assertEquals(pregunta.obtenerTipo().getClass(), TipoGroupChoice.class);
        assertEquals(pregunta.getClass(),Pregunta.class);

    }

    @Test
    public void cargoUnaPreguntaOrderedChoiceYSeCreaCorrectamente() throws IOException, ParseException {
        List<Pregunta> preguntas = lectorDeArchivosJson.crearListaDePreguntas(Paths.get("src/main/resources/orderedChoice.json").toAbsolutePath().toUri());

        Pregunta pregunta = preguntas.get(0);
        assertEquals(pregunta.obtenerTexto(), "¿Cuál es el orden de nacimientos?");
        assertEquals(pregunta.obtenerTipo().getClass(), TipoOrderedChoice.class);
        assertEquals(pregunta.getClass(),Pregunta.class);

    }


}
