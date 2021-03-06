package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Scanner;

public interface LectorDeArchivos {
    List<Pregunta> crearListaDePreguntas(URI nombreArchivo) throws IOException, ParseException;
}
