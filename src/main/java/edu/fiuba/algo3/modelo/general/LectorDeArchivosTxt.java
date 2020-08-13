package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LectorDeArchivosTxt implements LectorDeArchivos{
    @Override
    public List<Pregunta> crearListaDePreguntas(URI nombreArchivo) throws FileNotFoundException {
        List<Pregunta> nuevasPreguntas = new ArrayList<Pregunta>();

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
            nuevasPreguntas.add(nuevaPregunta);
        }
        return nuevasPreguntas;
    }
    private List<Opcion> separarOpciones(String posibles, String correcta){
        String[] opcionesSeparadas = posibles.split(",");
        List<String> listaPosibles = Arrays.asList(opcionesSeparadas);
        List<Opcion> listaOpciones = new ArrayList<>();

        for (String opcion:listaPosibles){
            Opcion nuevaOpcion;
            if (opcion.equals(correcta)){
                nuevaOpcion = new Opcion(opcion, true);
            }
            else{
                nuevaOpcion = new Opcion(opcion);
            }
            listaOpciones.add(nuevaOpcion);
        }
        return listaOpciones;
    }
}
