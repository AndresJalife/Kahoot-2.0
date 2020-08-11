package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public interface LectorDeArchivos {
    List<Pregunta> crearListaDePreguntas(String nombreArchivo) throws FileNotFoundException;
}
