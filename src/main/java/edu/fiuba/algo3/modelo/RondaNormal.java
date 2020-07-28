package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;

public class RondaNormal implements IRonda {


    private Pregunta preguntaActual;
    private HashMap<Jugador, Multiplicador> multiplicadores;
    private List<Jugador> jugadores;
    private HashMap<Jugador, List<Opcion>> respuestasDeJugadores;

    public RondaNormal(Pregunta pregunta, List<Jugador> nuevosJugadores){
        preguntaActual = pregunta;
        jugadores = nuevosJugadores;
    }

    //    @Override
    //    public void agregarExclusividad(IModificador exclusividad) throws MultiplicadorEnRondaExclusivaError {
    //        throw new MultiplicadorEnRondaExclusivaError();
    //    }
    //
    //    @Override
    //    public void agregarMultiplicador(IModificador multiplicador){multiplicadores.add(multiplicador);}

    @Override
    public void mostrarPregunta(){
        System.out.println(preguntaActual.getPregunta());
    }

    @Override
    public void mostrarModificadores(Jugador jugador){
        MultiplicadorX2 x2 = jugador.obtenerMultiplicadorX2();
        MultiplicadorX3 x3 = jugador.obtenerMultiplicadorX3();
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
    public void mostrarPosiblesRespuestas(){
        for(Opcion opcion: preguntaActual.obtenerOpciones()) {
            System.out.println(opcion.obtenerTextoamostrar());
        }
//        VER COMO SE PUEDEN MOSTRAR TODAS JUNTAS
    }

    @Override
    public void pedirRespuesta(Jugador jugador){
        respuestasDeJugadores.put(jugador, input(Opcion opcion));
//        CORREGIR EL INPUT
    }

    @Override
    public void mostrarRespuestaCorrecta(){
        for(Opcion opcion: preguntaActual.obtenerRespuestasCorrecta()) {
            System.out.println(opcion.obtenerTextoamostrar());
        }
    }

    @Override
    public void actualizar(Jugador jugador) {
        List<Opcion> respuestas = jugador.getRespuestas();

        int puntajeBase = this.preguntaActual.calcularPuntaje(respuestas);
        puntajeBase = (multiplicadores.get(jugador)).modificarPuntaje(puntajeBase);
        jugador.agregarPuntaje(puntaje);
    }

    @Override
    public void comenzar(){
        for(Jugador jugador:jugadores) {
            this.mostrarPregunta();
            this.mostrarModificadores(jugador);
            this.mostrarPosiblesRespuestas();
            this.pedirRespuesta(jugador);
            this.actualizar(jugador);
        }
        this.mostrarRespuestaCorrecta();
    }
}