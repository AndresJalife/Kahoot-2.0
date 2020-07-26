package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
    String pregunta;
    List<Opcion> opciones;
    ITipoDePregunta tipo;
    IModoDePregunta modo;

    public Pregunta(String pregunta, List<Opcion> opciones,ITipoDePregunta tipo,IModoDePregunta modo) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.tipo = tipo;
        this.modo = modo;
    }
    public List<Opcion> getRespuesta() {
        List<Opcion> respuestas = new ArrayList<>();
        for(Opcion opcion:opciones){
            if(opcion.Respuesta())
                respuestas.add(opcion);
        }
        return respuestas;
    }

    public int calcularPuntaje(List<Opcion> respuestasJugador){
        for(Opcion opcion:opciones){
            if(opcion.Respuesta())
                return 1;
        }
        return 0;
    }
}
