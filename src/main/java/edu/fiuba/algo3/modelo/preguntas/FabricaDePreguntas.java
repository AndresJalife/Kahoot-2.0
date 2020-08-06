package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.List;

public class FabricaDePreguntas {
    public Pregunta crearPregunta(String pregunta, List<Opcion> opciones, String tipoPregunta, String modoPregunta) {

        if (tipoPregunta.equalsIgnoreCase("VerdaderoFalso")) {

            if (modoPregunta.equalsIgnoreCase("Clasico")) {
                return new Pregunta(pregunta, opciones,new TipoVerdaderoYFalso(), new ModoClasico());
            }
            else if (modoPregunta.equalsIgnoreCase("ConPenalidad")) {
                return new Pregunta(pregunta, opciones, new TipoVerdaderoYFalso(), new ModoConPenalidad());
            }
        }
        else if(tipoPregunta.equalsIgnoreCase("MultipleChoice")){

            if (modoPregunta.equalsIgnoreCase("Clasico")) {
                return new Pregunta(pregunta, opciones,new TipoMultipleChoice(), new ModoClasico());
            }
            else if (modoPregunta.equalsIgnoreCase("ConPenalidad")) {
                return new Pregunta(pregunta, opciones, new TipoMultipleChoice(), new ModoConPenalidad());
            }
            else if (modoPregunta.equalsIgnoreCase("ConPuntajeParcial")) {
                return new Pregunta(pregunta, opciones, new TipoMultipleChoice(), new ModoPuntajeParcial());
            }
        }
        else if(tipoPregunta.equalsIgnoreCase("GroupChoice")){
            return new Pregunta(pregunta,opciones,tiempo,puntajePorRespuesta,new TipoGroupChoice(),new ModoClasico());
        }else if(tipoPregunta.equalsIgnoreCase("OrderedChoice")){
            return new Pregunta(pregunta,opciones,tiempo,puntajePorRespuesta,new TipoOrderedChoice(),new ModoClasico());
        }
        return null;
    }
}
