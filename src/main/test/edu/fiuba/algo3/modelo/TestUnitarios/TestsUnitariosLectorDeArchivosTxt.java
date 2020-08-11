package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.general.LectorDeArchivosTxt;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsUnitariosLectorDeArchivosTxt {
    LectorDeArchivosTxt lectorDeArchivosTxt = new LectorDeArchivosTxt();

    @Test
    public void cargoUnaPreguntaYEsSeCreaCorrectamente() throws FileNotFoundException {
        List<Pregunta> preguntas = lectorDeArchivosTxt.crearListaDePreguntas("./unaPregunta.txt");
        Pregunta pregunta = preguntas.get(0);

        assertEquals(pregunta.obtenerTexto(), "¿Como se llama tu mascota?");
    }
}
