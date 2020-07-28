package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.IModoDePregunta;
import edu.fiuba.algo3.modelo.ITipoDePregunta;
import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
    private String pregunta;
    private Opcion[] opcionesPosibles;
    private ITipoDePregunta tipo;
    private IModoDePregunta modo;
    private int tiempo;
    private int puntaje;


    public Pregunta(String pregunta, Opcion[] opcionesPosibles, int tiempo, int puntaje, ITipoDePregunta tipo, IModoDePregunta modo) {
        this.pregunta = pregunta;
        this.opcionesPosibles = opcionesPosibles;
        this.puntaje = puntaje;
        this.tiempo = tiempo;
        this.tipo = tipo;
        this.modo = modo;
    }

    public Opcion[] obtenerOpciones() {
        return opcionesPosibles;
    }

    public Opcion[] obtenerRespuestasCorrecta() {
        List<Opcion> respuestas = new ArrayList<>();
        for(var opcion : opcionesPosibles) {
            if(opcion.Respuesta())
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
