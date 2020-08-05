package edu.fiuba.algo3.modelo.TestUnitarios;

import org.junit.jupiter.api.Test;

public class TestUnitarioRonda {

    @Test
    public void TestRondaDevuelvePreguntaActual() {

    }

    private ArrayList<Jugador> crearJugadores() {
        var jugadores = new ArrayList<Jugador>();
        return jugadores;
    }

    @Test
    public void TestRondaDevuelvePreguntaActual() {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearJugadores();
        var ronda = new RondaNormal(pregunta, jugadores);
        assertEquals(pregunta, ronda.obtenerPreguntaActual());
    }

    @Test
    public void TestRondaDevuelveOpcionesCorrectas() {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearJugadores();
        var ronda = new RondaNormal(pregunta, jugadores);
        assertEquals(pregunta.obtenerRespuestasCorrectas(), ronda.obtenerRespuestasCorrectas());
    }

    }

    @Test
    public void TestRondaNormalActualizaElPuntaje() {

    }

    @Test
    public void TestRondaExclusividadActualizaElPuntaje() {

    }
}
