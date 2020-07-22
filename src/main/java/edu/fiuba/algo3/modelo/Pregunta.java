package edu.fiuba.algo3.modelo;

import java.util.List;

public class Pregunta {
    String pregunta;
    List<String> opciones;
    List<String> respuestas;
    ITipoDePregunta tipo;
    IModoDePregunta modo;

    public Pregunta(String pregunta, List<String> opciones, List<String> respuestas,ITipoDePregunta tipo,IModoDePregunta modo) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.respuestas = respuestas;
        this.tipo = tipo;
        this.modo = modo;
    }
    public List<String> getRespuesta() {
        return respuestas;
    }

    public int calcularPuntaje(List<String> respuestasJugador){
        if(respuestas.equals(respuestasJugador)){
            return 1;
        }
        return 0;
    }
}
