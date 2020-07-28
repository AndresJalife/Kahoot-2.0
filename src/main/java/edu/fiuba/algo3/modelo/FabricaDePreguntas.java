package edu.fiuba.algo3.modelo;

import java.util.List;

public class FabricaDePreguntas {
    public Pregunta obtenerPregunta(String pregunta, List<Opcion> opciones, String tipoPregunta, String modoPregunta) {
        if (tipoPregunta.equalsIgnoreCase("VerdaderoFalso")) {
            if (modoPregunta.equalsIgnoreCase("Clasico")) {
                return new Pregunta(pregunta, opciones, new VerdaderoFalso(), new Clasico());
            } else if (modoPregunta.equalsIgnoreCase("ConPenalidad")) {
                return new Pregunta(pregunta, opciones, new VerdaderoFalso(), new ConPenalidad());
            }
        }
        return null;
    }
}
