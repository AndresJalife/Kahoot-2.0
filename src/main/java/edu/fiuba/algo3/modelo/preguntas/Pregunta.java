package edu.fiuba.algo3.modelo.preguntas;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
    private String pregunta;
    private Opcion[] respuestasPosibles;
    private ITipoDePregunta tipo;
    private IModoDePregunta modo;
    private int tiempo;
    private int puntajePorRespuesta;


    public Pregunta(String pregunta, List<Opcion> opcionesPosibles, int tiempo, int puntajePorRespuesta, ITipoDePregunta tipo, IModoDePregunta modo) {
        this.pregunta = pregunta;
        this.respuestasPosibles = opcionesPosibles.toArray(Opcion[]::new);
        this.puntajePorRespuesta = puntajePorRespuesta;
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

    public int calcularPuntaje(int[] respuestasJugador) {
        var respuestasCorrectas = obtenerRespuestasCorrectas();
        var totalCorrectas = respuestasCorrectas.length;
        var correctas = 0;
        var incorrectas = 0;

        for (int value : respuestasJugador) {
            if(respuestasPosibles[value].esCorrecta())
                correctas++;
            else
                incorrectas++;
        }

        var puntaje = modo.calcularPuntaje(totalCorrectas, incorrectas, correctas);
        puntaje *= this.puntajePorRespuesta;
        return puntaje;
    }
}
