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

}
