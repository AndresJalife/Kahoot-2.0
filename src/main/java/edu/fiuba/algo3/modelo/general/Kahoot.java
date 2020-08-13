package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.excepciones.NoQuedanUsosExcepcion;
import edu.fiuba.algo3.modelo.preguntas.*;
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

    public void inicializarPreguntas(URI direccionArchivo) throws IOException, ParseException {
        LectorDeArchivos lector = new LectorDeArchivosJson();
        preguntas = lector.crearListaDePreguntas(direccionArchivo);
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

    public void comenzar() {
        // Agrego una pregunta para que poder correr las pruebas de las vistas
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Opcion("San Martin"));
        opciones.add(new Opcion("15", true));
        Pregunta aux = new Pregunta("7+5", opciones,new TipoVerdaderoYFalso(),new ModoClasico());
        preguntas.add(aux);

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

    public boolean cambiarRonda(){
        if(ronda.hasNext()){
            rondaActual = (RondaBase) ronda.next();
            return true;
        }
        return false;
    }
}
