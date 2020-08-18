package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.lectorDeArchivos.LectorDeArchivosJson;
import edu.fiuba.algo3.lectorDeArchivos.LectorDeArchivosTxt;
import edu.fiuba.algo3.modelo.excepciones.ExtensionInvalidaExcepcion;
import edu.fiuba.algo3.modelo.excepciones.NoQuedanUsosExcepcion;
import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.scene.control.Alert;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.util.*;

public class Kahoot {
    private List<Jugador> jugadores;
    private List<Pregunta> preguntas;
    private List<RondaBase> rondas;
    private Iterator ronda;
    private RondaBase rondaActual;

    public Kahoot(){
        rondas = new ArrayList<>();
        preguntas = new ArrayList<>();
        jugadores = new ArrayList<>();
    }

    public void inicializarPreguntas(URI nombreArchivo) throws IOException, ParseException, ExtensionInvalidaExcepcion {
        LectorDeArchivos lector = null;
        if (getFileExtension(nombreArchivo.toString()).contains("json")){
            lector = new LectorDeArchivosJson();
        } else if (getFileExtension(nombreArchivo.toString()).contains("txt")){
            lector = new LectorDeArchivosTxt();
        }
        if (lector == null){
            throw new ExtensionInvalidaExcepcion("Extensión invalida del archivo.");
        } else {
            preguntas = lector.crearListaDePreguntas(nombreArchivo);
        }
    }
    
    public String getFileExtension(String fileName){
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }


    public void agregarJugador(String nombre) {
        Jugador nuevoJugador = new Jugador(nombre);
        jugadores.add(nuevoJugador);
    }

    public void jugadorResponder(Jugador jugador, List<RespuestaDeJugador> respuestas){
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

    public void utilizarModificador(Jugador jugador, IModificador modificador){
        rondaActual.usarModificador(jugador, modificador);
    }

    public void comenzar() {

        for(Pregunta pregunta: preguntas) {
            if (pregunta.tienePenalidad()) {
                RondaNormal rondaNormal = new RondaNormal(pregunta, jugadores);
                rondas.add(rondaNormal);
            }
            else {
                RondaExclusividad rondaExclusividad = new RondaExclusividad(pregunta, jugadores);
                rondas.add(rondaExclusividad);
            }
        }
        ronda = rondas.iterator();
        rondaActual = (RondaBase) ronda.next();
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

    public boolean esRondaFinal(){
        return !ronda.hasNext();
    }

    public boolean cambiarRonda(){
        if(!this.esRondaFinal()){
            rondaActual = (RondaBase) ronda.next();
            return true;
        }
        return false;
    }

    public Jugador obtenerPrimerJugador(){ return this.obtenerJugadores().get(0); }
}
