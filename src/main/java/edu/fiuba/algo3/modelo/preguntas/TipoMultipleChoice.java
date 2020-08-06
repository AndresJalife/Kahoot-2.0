package edu.fiuba.algo3.modelo.preguntas;

import java.util.List;

public class TipoMultipleChoice implements ITipoDePregunta{

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
        int correctas= 0;
        for (Opcion opcion : respuestasJugador) {
            if(opcion.esCorrecta())
                correctas++;
        }
        return correctas;
    }

    @Override
    public int cantIncorrectas(List<Opcion> opciones, List<Opcion> respuestasJugador) {
        int incorrectas= 0;
        for (Opcion opcion : respuestasJugador) {
            if(!opcion.esCorrecta())
                incorrectas++;
        }
        return incorrectas;
    }
}
