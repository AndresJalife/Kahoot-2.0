package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kahoot {
    private List<Jugador> jugadores;
    private List<Pregunta> preguntas;
    private RondaBase rondaActual;

    public Kahoot(String archivoPreguntas){
        preguntas = new ArrayList<>();
        jugadores = new ArrayList<>();
        try {
            inicializarPreguntas(archivoPreguntas);
        } catch(FileNotFoundException exp) {
//        tratar la excepción
        }
    }

<<<<<<< HEAD
    private void inicializarPreguntas(String nombreArchivo) throws FileNotFoundException {
        preguntas = new LectorDeArchivosTxt().crearListaDePreguntas(nombreArchivo);
=======
    public void inicializarPreguntas(String nombreArchivo) throws FileNotFoundException {
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
>>>>>>> b7de401aa84c86c502fb95f019dfae7054dffbb1
    }

    public void agregarJugador(String nombre) {
        Jugador nuevoJugador = new Jugador(nombre);
        jugadores.add(nuevoJugador);
    }

    public void jugadorResponder(Jugador jugador, List<Opcion> respuestas){
        rondaActual.guardarRespuestas(jugador, respuestas);
    }

    public void actualizarPuntaje(){
        try{
            rondaActual.actualizarPuntaje();
        } catch (NoQuedanUsosExcepcion excepcion) {
//            tratarla
        }
    }

    public List<IModificador> obtenerModificadores(Jugador jugador){
        return rondaActual.obtenerModificadores(jugador);
    }

    public void comenzar() {
        // Agrego una pregunta para que poder correr las pruebas de las vistas
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Opcion("San Martin"));
        opciones.add(new Opcion("15", true));
        Pregunta aux = new Pregunta("7+5", opciones,new TipoVerdaderoYFalso(),new ModoClasico());
        preguntas.add(aux);

        for(Pregunta pregunta: preguntas) {
            if (pregunta.tienePenalidad()) {
                rondaActual = new RondaNormal(pregunta, jugadores);
            }
            else {
                rondaActual = new RondaExclusividad(pregunta, jugadores);
            }
        }
    }

    public Pregunta obtenerPreguntaActual(){
        return rondaActual.obtenerPreguntaActual();
    }

    public List<Jugador> obtenerJugadores(){
        return jugadores;
    }

    public boolean todosContestaron(){
        return rondaActual.todosContestaron();
    }
}
