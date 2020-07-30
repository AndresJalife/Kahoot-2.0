package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.List;

public class FabricaDePreguntas {
    public Pregunta crearPregunta(String pregunta, List<Opcion> opciones,int tiempo,int puntajePorRespuesta, String tipoPregunta, String modoPregunta) {

        if (tipoPregunta.equalsIgnoreCase("VerdaderoFalso")) {

            if (modoPregunta.equalsIgnoreCase("Clasico")) {
                return new Pregunta(pregunta, opciones, tiempo,puntajePorRespuesta,new TipoVerdaderoYFalso(), new ModoClasico());
            }
            else if (modoPregunta.equalsIgnoreCase("ConPenalidad")) {
                return new Pregunta(pregunta, opciones, tiempo,puntajePorRespuesta, new TipoVerdaderoYFalso(), new ModoConPenalidad());
            }
        }
        else if(tipoPregunta.equalsIgnoreCase("MultipleChoice")){

            if (modoPregunta.equalsIgnoreCase("Clasico")) {
                return new Pregunta(pregunta, opciones, tiempo,puntajePorRespuesta,new TipoMultipleChoice(), new ModoClasico());
            }
            else if (modoPregunta.equalsIgnoreCase("ConPenalidad")) {
                return new Pregunta(pregunta, opciones, tiempo,puntajePorRespuesta, new TipoMultipleChoice(), new ModoConPenalidad());
            }
            else if (modoPregunta.equalsIgnoreCase("ConPuntajeParcial")) {
                return new Pregunta(pregunta, opciones, tiempo, puntajePorRespuesta, new TipoMultipleChoice(), new ModoPuntajeParcial());
            }
        }
        return null;
    }
}
