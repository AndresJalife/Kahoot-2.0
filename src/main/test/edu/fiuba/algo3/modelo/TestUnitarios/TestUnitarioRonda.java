package edu.fiuba.algo3.modelo.TestUnitarios;

import org.junit.jupiter.api.Test;

public class TestUnitarioRonda {

    @Test
    public void TestRondaDevuelvePreguntaActual() {

    }

    @Test
    public void TestRondaDevuelveOpcionesCorrectas() {

    @Test
    public void TestRondaDevuelvePreguntaActual() {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearJugadores();
        var ronda = new RondaNormal(pregunta, jugadores);
        assertEquals(pregunta, ronda.obtenerPreguntaActual());
    }

    @Test
    public void TestRondaDevuelveOpcionesCorrectas() {

    }

    @Test
    public void TestRondaNormalActualizaElPuntaje() {

    }

    @Test
    public void TestRondaExclusividadActualizaElPuntaje() {

    }
}
