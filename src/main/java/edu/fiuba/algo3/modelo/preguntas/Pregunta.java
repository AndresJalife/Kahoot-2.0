package edu.fiuba.algo3.modelo.preguntas;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
    private String pregunta;
    private Opcion[] respuestasPosibles;
    private ITipoDePregunta tipo;
    private IModoDePregunta modo;
    private int tiempo;
    private int puntaje;


    public Pregunta(String pregunta, Opcion[] opcionesPosibles, int tiempo, int puntaje, ITipoDePregunta tipo, IModoDePregunta modo) {
        this.pregunta = pregunta;
        this.respuestasPosibles = opcionesPosibles;
        this.puntaje = puntaje;
        this.tiempo = tiempo;
        this.tipo = tipo;
        this.modo = modo;
    }

    public int obtenerTiempo() {
        return tiempo;
    }

    public Opcion[] obtenerOpciones() {
        return respuestasPosibles;
    }

    public Opcion[] obtenerRespuestasCorrectas() {
        List<Opcion> respuestas = new ArrayList<>();
        for(var opcion : respuestasPosibles) {
            if(opcion.esCorrecta())
                respuestas.add(opcion);
        }
        return respuestas.toArray(Opcion[]::new);
    }

    public int calcularPuntaje(Opcion[] respuestasJugador) {
        for (Opcion opcion : opciones) {
            if(opcion.Respuesta())
                return 1;
        }
        return 0;
    }
}
