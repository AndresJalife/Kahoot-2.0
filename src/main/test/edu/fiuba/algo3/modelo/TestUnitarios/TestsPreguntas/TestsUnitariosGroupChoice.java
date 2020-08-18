package edu.fiuba.algo3.modelo.TestUnitarios.TestsPreguntas;


import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.preguntas.*;
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

        Pregunta pregunta = new Pregunta("Seleccionar los colores y los inmuebles", opciones, new TipoGroupChoice(), new ModoClasico());
        respuestas.add(Opcion1);
        respuestas.add(Opcion3);

        assertEquals(respuestas, pregunta.obtenerRespuestasCorrectas());
    }

    @Test
    public void ingresarRespuestaGroupChoiceYContestaBien() {
        List<Opcion> opciones = new ArrayList<>();
        List<RespuestaDeJugador> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        var grupoQueSeDebeSeleccionar = 2;
        Opcion Opcion1 = new Opcion("Azul", 2, grupoQueSeDebeSeleccionar);
        Opcion Opcion2 = new Opcion("Casa", 1, grupoQueSeDebeSeleccionar);
        Opcion Opcion3 = new Opcion("Verde", 2, grupoQueSeDebeSeleccionar);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        Pregunta pregunta = new Pregunta("Seleccionar los colores y los inmuebles", opciones, new TipoGroupChoice(), new ModoClasico());
        respuestas.add(new RespuestaDeJugador(Opcion1, grupoQueSeDebeSeleccionar));
        respuestas.add(new RespuestaDeJugador(Opcion3, grupoQueSeDebeSeleccionar));

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(1, jugador.obtenerPuntaje());
    }


    @Test
    public void ingresarRespuestaGroupChoiceYContestaUnoMal() {
        List<Opcion> opciones = new ArrayList<>();
        List<RespuestaDeJugador> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Azul", 5, 5);
        Opcion Opcion2 = new Opcion("Casa", 2, 5);
        Opcion Opcion3 = new Opcion("Verde", 5, 5);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        Pregunta pregunta = new Pregunta("Seleccionar los colores y los inmuebles", opciones, new TipoGroupChoice(), new ModoClasico());
        respuestas.add(new RespuestaDeJugador(Opcion2, 5));

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(0, jugador.obtenerPuntaje());
    }

    @Test
    public void ingresarRespuestaGroupChoiceYContestaUnParMal() {
        List<Opcion> opciones = new ArrayList<>();
        List<RespuestaDeJugador> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Azul", 5, 5);
        Opcion Opcion2 = new Opcion("Casa", 2, 5);
        Opcion Opcion3 = new Opcion("Verde", 3, 5);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        Pregunta pregunta = new Pregunta("Seleccionar los colores y los inmuebles", opciones, new TipoGroupChoice(), new ModoClasico());
        respuestas.add(new RespuestaDeJugador(Opcion2, 5));

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(0, jugador.obtenerPuntaje());
    }

    @Test
    public void ingresarRespuestaGroupChoiceYContestaTodosMal() {
        List<Opcion> opciones = new ArrayList<>();
        List<RespuestaDeJugador> respuestas = new ArrayList<>();
        Jugador jugador = new Jugador("Jorge");
        Opcion Opcion1 = new Opcion("Azul", 4, 5);
        Opcion Opcion2 = new Opcion("Casa", 2, 5);
        Opcion Opcion3 = new Opcion("Verde", 3, 5);

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        opciones.add(Opcion3);

        Pregunta pregunta = new Pregunta("Seleccionar los colores y los inmuebles", opciones, new TipoGroupChoice(), new ModoClasico());
        respuestas.add(new RespuestaDeJugador(Opcion2, 5));

        jugador.agregarPuntaje(pregunta.calcularPuntaje(respuestas));

        assertEquals(0, jugador.obtenerPuntaje());
    }
}