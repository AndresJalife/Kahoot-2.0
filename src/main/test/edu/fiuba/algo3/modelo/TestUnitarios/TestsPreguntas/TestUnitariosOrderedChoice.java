package edu.fiuba.algo3.modelo.TestUnitarios.TestsPreguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnitariosOrderedChoice {

    @Test
    public void ingresarRespuestaMultipleChoiceClasico() {
        List<Opcion> respuestas = new ArrayList<>();
        Opcion Opcion1 = new Opcion("Primera", true);
        Opcion Opcion2 = new Opcion("Segunda", true);
        Opcion Opcion3 = new Opcion("Tercera", true);

        respuestas.add(Opcion1);
        respuestas.add(Opcion2);
        respuestas.add(Opcion3);

        Pregunta pregunta = new Pregunta("Francia es un pais", respuestas, new TipoOrderedChoice(), new ModoClasico());

        assertEquals(respuestas, pregunta.obtenerRespuestasCorrectas());
    }
}
