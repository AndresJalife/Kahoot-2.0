package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.List;

public class FabricaDePreguntas {
    public Pregunta crearPregunta(String pregunta, List<Opcion> opciones, String tipoPregunta, String modoPregunta) {
        Pregunta nuevaPregunta = null;
        if (tipoPregunta.equalsIgnoreCase("VerdaderoFalso")) {
            if (modoPregunta.equalsIgnoreCase("Clasico")) {
                nuevaPregunta = new Pregunta(pregunta, opciones,new TipoVerdaderoYFalso(), new ModoClasico());
            }
            else if (modoPregunta.equalsIgnoreCase("ConPenalidad")) {
                nuevaPregunta = new Pregunta(pregunta, opciones, new TipoVerdaderoYFalso(), new ModoConPenalidad());
            }
        }
        else if(tipoPregunta.equalsIgnoreCase("MultipleChoice")){

            if (modoPregunta.equalsIgnoreCase("Clasico")) {
                nuevaPregunta = new Pregunta(pregunta, opciones,new TipoMultipleChoice(), new ModoClasico());
            }
            else if (modoPregunta.equalsIgnoreCase("ConPenalidad")) {
                nuevaPregunta = new Pregunta(pregunta, opciones, new TipoMultipleChoice(), new ModoConPenalidad());
            }
            else if (modoPregunta.equalsIgnoreCase("ConPuntajeParcial")) {
                nuevaPregunta = new Pregunta(pregunta, opciones, new TipoMultipleChoice(), new ModoPuntajeParcial());
            }
        }
        else if(tipoPregunta.equalsIgnoreCase("GroupChoice")){
            nuevaPregunta = new Pregunta(pregunta,opciones,new TipoGroupChoice(),new ModoClasico());
        }else if(tipoPregunta.equalsIgnoreCase("OrderedChoice")){
            nuevaPregunta = new Pregunta(pregunta,opciones,new TipoOrderedChoice(),new ModoClasico());
        }
        if(nuevaPregunta != null && nuevaPregunta.esPreguntaValida()){
            return nuevaPregunta;
        }
        return null;
    }
}
