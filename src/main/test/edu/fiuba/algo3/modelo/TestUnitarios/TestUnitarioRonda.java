package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.NoQuedanUsosExcepcion;
import edu.fiuba.algo3.modelo.general.RondaExclusividad;
import edu.fiuba.algo3.modelo.general.RondaNormal;
import edu.fiuba.algo3.modelo.preguntas.ModoClasico;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.TipoMultipleChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnitarioRonda {

    private Pregunta crearPregunta() {
        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> respuestas = new ArrayList<>();
        Opcion Opcion1 = new Opcion("Si", true);
        Opcion Opcion2 = new Opcion("No");

        opciones.add(Opcion1);
        opciones.add(Opcion2);
        return new Pregunta("Francia es un pais", opciones, new TipoMultipleChoice(), new ModoClasico());
    }

    private ArrayList<Jugador> crearListaJugadores() {
        var jugadores = new ArrayList<Jugador>();
        return jugadores;
    }

    @Test
    public void TestRondaDevuelvePreguntaActual() {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearListaJugadores();
        var ronda = new RondaNormal(pregunta, jugadores);
        assertEquals(pregunta, ronda.obtenerPreguntaActual());
    }

    @Test
    public void TestRondaDevuelveOpcionesCorrectas() {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearListaJugadores();
        var ronda = new RondaNormal(pregunta, jugadores);
        assertEquals(pregunta.obtenerRespuestasCorrectas(), ronda.obtenerRespuestasCorrectas());
    }

    @Test
    public void TestRondaNormalDevuelveOpcionesTotales() {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearListaJugadores();
        var ronda = new RondaNormal(pregunta, jugadores);
        assertEquals(pregunta.obtenerOpciones(), ronda.obtenerPosiblesRespuestas());
    }

    @Test
    public void TestRondaNormalActualizaElPuntajeSiAcierta() throws NoQuedanUsosExcepcion {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearListaJugadores();

        var jugador = new Jugador("Test");
        jugadores.add(jugador);

        var ronda = new RondaNormal(pregunta, jugadores);
        ronda.guardarRespuestas(jugador, pregunta.obtenerRespuestasCorrectas());
        ronda.actualizarPuntaje();

        assertEquals(1, jugador.obtenerPuntaje());
    }

    @Test
    public void TestRondaNormalNoActualizaElPuntajeSiSeEquivoca() throws NoQuedanUsosExcepcion {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearListaJugadores();

        var jugador = new Jugador("Test");
        jugadores.add(jugador);

        var ronda = new RondaNormal(pregunta, jugadores);
        ronda.guardarRespuestas(jugador, new ArrayList<>());
        ronda.actualizarPuntaje();

        assertEquals(0, jugador.obtenerPuntaje());
    }

    @Test
    public void TestRondaExclusividadActualizaElPuntajeSiAcierta() throws NoQuedanUsosExcepcion {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearListaJugadores();

        var jugador = new Jugador("Test");
        jugadores.add(jugador);

        var ronda = new RondaExclusividad(pregunta, jugadores);
        ronda.guardarRespuestas(jugador, pregunta.obtenerRespuestasCorrectas());
        ronda.actualizarPuntaje();

        assertEquals(1, jugador.obtenerPuntaje());
    }

    @Test
    public void TestRondaExclusividadNoActualizaElPuntajeSiSeEquivoca() throws NoQuedanUsosExcepcion {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearListaJugadores();

        var jugador = new Jugador("Test");
        jugadores.add(jugador);

        var ronda = new RondaExclusividad(pregunta, jugadores);
        ronda.guardarRespuestas(jugador, new ArrayList<>());
        ronda.actualizarPuntaje();

        assertEquals(0, jugador.obtenerPuntaje());
    }

    @Test
    public void TestRondaNormalUtilizaMultiplicadores() {

    }
}
