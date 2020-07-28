package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.HashMap;
import java.util.List;

public class RondaNormal implements IRonda {


    private Pregunta preguntaActual;
    private HashMap<Jugador, Multiplicador> multiplicadores;
    private List<Jugador> jugadores;
    private HashMap<Jugador, int[]> respuestasDeJugadores;

    public RondaNormal(Pregunta pregunta, List<Jugador> nuevosJugadores) {
        preguntaActual = pregunta;
        jugadores = nuevosJugadores;
        respuestasDeJugadores = new HashMap<>();
    }

    @Override
    public void mostrarPregunta() {

        System.out.println(preguntaActual.obtenerTexto());
    }

    @Override
    public void mostrarModificadores(Jugador jugador) {
        Multiplicadorx2 x2 = jugador.obtenerMultiplicadorX2();
        Multiplicadorx3 x3 = jugador.obtenerMultiplicadorX3();
        if (x2.quedanUsos()){
            System.out.println("X2");
        }
        if (x3.quedanUsos()){
            System.out.println("X3");
        }
    //        MOSTRAR POR PANTALLA BOTONES MULTIPLICADORES Y QUE APRIETE SOLO 1
    //        HAY QUE AGREGARLOS A LA LISTA
    }

    @Override
    public void mostrarPosiblesRespuestas() {
        for(Opcion opcion: preguntaActual.obtenerOpciones()) {
            System.out.println(opcion.obtenerTexto());
        }
//        VER COMO SE PUEDEN MOSTRAR TODAS JUNTAS
    }

    @Override
    public void pedirRespuesta(Jugador jugador) {
        //respuestasDeJugadores.put(jugador, input(Opcion opcion));
//        CORREGIR EL INPUT
    }

    @Override
    public void mostrarRespuestaCorrecta(){
        for(Opcion opcion: preguntaActual.obtenerRespuestasCorrectas()) {
            System.out.println(opcion.obtenerTexto());
        }
    }

    @Override
    public void actualizar(Jugador jugador) {
        var respuestas = respuestasDeJugadores.get(jugador);

        int puntaje = this.preguntaActual.calcularPuntaje(respuestas);
        puntaje = (multiplicadores.get(jugador)).modificarPuntaje(puntaje);
        jugador.agregarPuntaje(puntaje);
    }

    @Override
    public void comenzar() {
        for (Jugador jugador:jugadores) {
            this.mostrarPregunta();
            this.mostrarModificadores(jugador);
            this.mostrarPosiblesRespuestas();
            this.pedirRespuesta(jugador);
            this.actualizar(jugador);
        }
        this.mostrarRespuestaCorrecta();
    }
}