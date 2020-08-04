package edu.fiuba.algo3.modelo.TestUnitarios.TestsPreguntas;


import edu.fiuba.algo3.modelo.preguntas.ModoClasico;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsUnitariosGroupChoice {

    @Test
    public void ingresarRespuestaMultipleChoiceClasico() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> primergrupo = new ArrayList<>();
        List<Opcion> segundogrupo = new ArrayList<>();
        Opcion Opcion1 = new Opcion("Rojo", grupo:1);
        Opcion Opcion2 = new Opcion("Azul",grupo:1);
        Opcion Opcion3 = new Opcion("Cuadrado", grupo:2);
        Opcion Opcion4 = new Opcion("Triangulo", grupo:2);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);
        opciones.add(Opcion4);

        Pregunta pregunta = new Pregunta("Seleccionar los colores", opciones, 1, 1, new TipoGroupChoice(), new ModoClasico());

        primergrupo.add(Opcion1);
        primergrupo.add(Opcion2);
        segundogrupo.add(Opcion3);
        segundogrupo.add(Opcion4);

        assertEquals(primergrupo, pregunta.obtenerPrimerGrupo());
        assertEquals(segundogrupo, pregunta.obtenerSegundoGrupo());
    }
}
