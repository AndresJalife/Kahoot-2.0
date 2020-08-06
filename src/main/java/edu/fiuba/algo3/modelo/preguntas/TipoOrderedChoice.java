package edu.fiuba.algo3.modelo.preguntas;

import java.util.List;

public class TipoOrderedChoice implements ITipoDePregunta{

    public TipoOrderedChoice() {}

    @Override
    public boolean opcionesValidas(List<Opcion> opciones) {
        int contadorRespuestasCorrectas = 0;
        if(opciones.size() >= 2 && opciones.size()<=5){
            for(Opcion opcion: opciones){
                if(opcion.esCorrecta()){
                    contadorRespuestasCorrectas++;
                }
            }
        }
        return (contadorRespuestasCorrectas > 0);
    }
        @Override
    public int cantCorrectas(List<Opcion> opciones, List<Opcion> respuestasJugador) {
        int correctas = 0;
        for (int i = 0; i < opciones.size() && i< respuestasJugador.size(); i++) {
            if (opciones.get(i).obtenerTexto().equals(respuestasJugador.get(i).obtenerTexto())) {
                correctas++;
            }
        }
        return correctas;
    }

    @Override
    public int cantIncorrectas(List<Opcion> opciones, List<Opcion> respuestasJugador) {
        int incorrectas = 0;
        for (int i = 0; (i < opciones.size() &&i< respuestasJugador.size()); i++) {
            if (!opciones.get(i).obtenerTexto().equals(respuestasJugador.get(i).obtenerTexto())) {
                incorrectas++;
            }
        }
        return incorrectas;
    }
}
