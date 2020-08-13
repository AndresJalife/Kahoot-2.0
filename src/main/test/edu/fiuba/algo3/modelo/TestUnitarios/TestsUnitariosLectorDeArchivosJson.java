package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.general.LectorDeArchivosJson;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

public class TestsUnitariosLectorDeArchivosJson {
    LectorDeArchivosJson lectorDeArchivosJson = new LectorDeArchivosJson();

    @Test
    public void cargoUnaPreguntaYEsSeCreaCorrectamente() throws IOException, ParseException {
        List<Pregunta> preguntas = lectorDeArchivosJson.crearListaDePreguntas("./src/main/test/edu/fiuba/algo3/modelo/TestUnitarios/unaPregunta.json");

        Pregunta pregunta = preguntas.get(0);
        assertEquals(pregunta.obtenerTexto(), "¿Era Abraham Lincoln un asesino?");
        assertEquals(pregunta.getClass(),Pregunta.class);
    }

}
