package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoClasicoTest {

    @Test
    public void ingresarRespuestaVerdaderoFalsoClasico() {
        List<Opcion> opciones = new ArrayList<>();
        var Verdadero = new Opcion("Verdadero", true);
        var Falso = new Opcion("Falso");

        opciones.add(Verdadero);
        opciones.add(Falso);

        var pregunta = new Pregunta("2 + 2 = 4", opciones, 1, 1, new TipoVerdaderoYFalso(), new ModoClasico());
        /* Selecciona la primer respuesta */
        var respuestaJugador = 0;

        assertEquals(new Opcion[]{ opciones.get(respuestaJugador) }, pregunta.obtenerRespuestasCorrectas());
    }


    @Test
    public void ingresarListaRespuestasYAsignarPuntosAJugador() {
        List<Opcion> opciones = new ArrayList<>();
        var jugador = new Jugador("Mathias");
        var Verdadero = new Opcion("Verdadero", true);
        var Falso = new Opcion("Falso");

        opciones.add(Verdadero);
        opciones.add(Falso);

        var pregunta = new Pregunta("2 + 2 = 4", opciones, 1, 1, new TipoVerdaderoYFalso(), new ModoClasico());
        /* Selecciona la primer respuesta */
        var respuestasJugador = new int[]{0};

        jugador.agregarRespuestas(respuestasJugador);
        jugador.agregarPuntaje(
                pregunta.calcularPuntaje(jugador.getRespuestas())
        );

        assertEquals(1, jugador.obtenerPuntaje());
    }


}