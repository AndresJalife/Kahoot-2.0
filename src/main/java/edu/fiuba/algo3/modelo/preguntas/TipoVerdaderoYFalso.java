package edu.fiuba.algo3.modelo.preguntas;

import java.util.List;

public class TipoVerdaderoYFalso implements ITipoDePregunta {

    public TipoVerdaderoYFalso() {
    }

    @Override
    public boolean opcionesValidas(List<Opcion> opciones) {
        if(opciones.size() != 2){
            return false;
        }

        int contadorRespuestasCorrectas = 0;
        for(Opcion opcion: opciones){
            if(opcion.esCorrecta()){
                contadorRespuestasCorrectas++;
            }
        }
        return (contadorRespuestasCorrectas == 1);
    }


    @Override
    public int cantCorrectas(List<Opcion> opciones, List<RespuestaDeJugador> respuestasJugador) {
        int correctas= 0;
        for (var opcion : respuestasJugador) {
            if(opcion.esCorrecta())
                correctas++;
        }
        return correctas;
    }

    @Override
    public int cantIncorrectas(List<Opcion> opciones, List<RespuestaDeJugador> respuestasJugador) {
        int incorrectas= 0;
        for (var opcion : respuestasJugador) {
            if(!opcion.esCorrecta())
                incorrectas++;
        }
        return incorrectas;
    }

}
