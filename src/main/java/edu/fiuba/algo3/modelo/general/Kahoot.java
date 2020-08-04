package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.RondaBase;
import edu.fiuba.algo3.modelo.general.RondaExclusividad;
import edu.fiuba.algo3.modelo.general.RondaNormal;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class Kahoot {
    private List<Jugador> jugadores;
    private List<Pregunta> preguntas;
    private RondaBase rondaActual;

    public Kahoot() {
        jugadores = new ArrayList<>();
    }

    private void inicializarPreguntas() {
//        FALTA VER COMO ENTRAN LAS PREGS
    }


    private void inicializarJugadores() {
        boolean seguirAgregando = true;
        while (seguirAgregando){
            String nombre = "martin";
            Jugador nuevoJugador = new Jugador(nombre);
            seguirAgregando = false;
//            REFACTOR VER COMO SIGUE EL LOOP
        }
    }

    public void comenzar() {
        this.inicializarJugadores();
        this.inicializarPreguntas();
        for(Pregunta pregunta : preguntas) {
            if (pregunta.tienePenalidad()) {
                rondaActual = new RondaNormal(pregunta, jugadores);
            }
            else{
                rondaActual = new RondaExclusividad(pregunta, jugadores);
            }
            rondaActual.comenzar();
        }
    }
}
