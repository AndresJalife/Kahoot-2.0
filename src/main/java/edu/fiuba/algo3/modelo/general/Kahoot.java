package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.RondaBase;
import edu.fiuba.algo3.modelo.general.RondaExclusividad;
import edu.fiuba.algo3.modelo.general.RondaNormal;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kahoot {
    private List<Jugador> jugadores;
    private List<Pregunta> preguntas;
    private RondaBase rondaActual;

    public Kahoot(String archivoPreguntas){
        jugadores = new ArrayList<>();
        try {
            inicializarPreguntas(archivoPreguntas);
        } catch(FileNotFoundException exp) {
//        tratar la excepción
        }
    }

    private void inicializarPreguntas(String nombreArchivo) throws FileNotFoundException {
        File archivoPreguntas = new File("nombreArchivo");
        Scanner sc = new Scanner(archivoPreguntas);

        while (sc.hasNext()){
            String nuevaPregunta = sc.nextLine();

        }
    }

    public void agregarJugador(String nombre) {
        Jugador nuevoJugador = new Jugador(nombre);
        jugadores.add(nuevoJugador);
    }

    public void comenzar() {
        for(Pregunta pregunta: preguntas) {
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
