package edu.fiuba.algo3.modelo.TestUnitarios.TestsPreguntas;


import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.preguntas.ModoClasico;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.TipoGroupChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsUnitariosGroupChoice {

    @Test
    public void ingresarRespuestaGroupChoice() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        //Se toma a las opciones correctas como "grupo 1" y a las incorrectas como "grupo 2"
        //Habria que volver a ver el constructor de opcion y la estructura de Pregunta
        // para poder hacer el codigo mas extensible(e.g: 3 grupos)
        Opcion Opcion1 = new Opcion("Azul", true);
        Opcion Opcion2 = new Opcion("Casa");
        Opcion Opcion3 = new Opcion("Verde", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        Pregunta pregunta = new Pregunta("Seleccionar los colores y los inmuebles", opciones, 1, 1, new TipoGroupChoice(), new ModoClasico());
        respuestas.add(Opcion1);
        respuestas.add(Opcion3);

        assertEquals(respuestas, pregunta.obtenerRespuestasCorrectas());
    }

    @Test
    public void ingresarRespuestaGroupChoiceYContestaBien() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Azul", true);
        Opcion Opcion2 = new Opcion("Casa");
        Opcion Opcion3 = new Opcion("Verde", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        Pregunta pregunta = new Pregunta("Seleccionar los colores y los inmuebles", opciones, 1, 1, new TipoGroupChoice(), new ModoClasico());
        respuestas.add(Opcion1);
        respuestas.add(Opcion3);

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(1, jugador.obtenerPuntaje());
    }


    @Test
    public void ingresarRespuestaGroupChoiceYContestaMal() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Azul", true);
        Opcion Opcion2 = new Opcion("Casa");
        Opcion Opcion3 = new Opcion("Verde", true);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        Pregunta pregunta = new Pregunta("Seleccionar los colores y los inmuebles", opciones, 1, 1, new TipoGroupChoice(), new ModoClasico());
        respuestas.add(Opcion2);

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(0, jugador.obtenerPuntaje());
    }
}

/*
public class TestsUnitariosGroupChoice {

    @Test
    public void ingresarRespuestaGroupChoice() {
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

    @Test
    public void ingresarRespuestaGroupChoiceYContestaBien() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> primergrupo = new ArrayList<>();
        List<Opcion> segundogrupo = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
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

        jugador.agregarPuntaje(pregunta.calcularPuntaje(primergrupo,segundogrupo));

        assertEquals(1, jugador.obtenerPuntaje());
    }
}
*/