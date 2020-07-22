package edu.fiuba.algo3.modelo;

import java.util.List;

public class Pregunta {
    String pregunta;
    List<String> opciones;
    List<String> respuestas;
    Tipo tipo;
    Modo modo;

    public Pregunta(String pregunta, List<String> opciones, List<String> respuestas,Tipo tipo,Modo modo) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.respuestas = respuestas;
        this.tipo = tipo;
        this.modo = modo;
    }
    public List<String> getRespuesta() {
        return respuestas;
    }

    public double calcularPuntaje(List<String> respuestasJugador){
        if(respuestas.equals(respuestasJugador)){
            return 1;
        }
        return 0;
    }
}
