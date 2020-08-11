package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public interface LectorDeArchivos {
    List<Pregunta> crearListaDePreguntas(String archivo);
    File archivoPreguntas = new File(nombreArchivo);
    Scanner sc = new Scanner(archivoPreguntas);

        while (sc.hasNext()){
        String textoPregunta = sc.nextLine();
        String[] datos = textoPregunta.split("/");

        FabricaDePreguntas fabricaDePreguntas = new FabricaDePreguntas();

        String tipo = datos[1];
        String modo = datos[0];
        String pregunta = datos[2];
        List<Opcion> opcionesPosibles = separarOpciones(datos[3], datos[4]);

        Pregunta nuevaPregunta = fabricaDePreguntas.crearPregunta(pregunta, opcionesPosibles, tipo, modo);
        preguntas.add(nuevaPregunta);
    }
}
