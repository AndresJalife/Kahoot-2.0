package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceClasicoTest {

    @Test
    public void ingresarRespuestaVerdaderoFalsoClasico() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        var Opcion1 = new Opcion("Si", true);
        var Opcion2 = new Opcion("No");
        var Opcion3 = new Opcion("Si, es correcta", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        var pregunta = new Pregunta("Francia es un pais", opciones, 1, 1, new TipoMultipleChoice(), new ModoClasico());
        /* Selecciona la primer respuesta */
        respuestas.add(Opcion1);
        respuestas.add(Opcion3);

        assertEquals(respuestas, pregunta.obtenerRespuestasCorrectas());
    }
}
