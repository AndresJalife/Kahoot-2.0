package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.excepciones.NoQuedanUsosExcepcion;
import edu.fiuba.algo3.modelo.general.RondaExclusividad;
import edu.fiuba.algo3.modelo.general.RondaNormal;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void TestRondaNormalActualizaElPuntajeSiAcierta() throws NoQuedanUsosExcepcion {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearListaJugadores();

        var jugador = new Jugador("Test");
        jugadores.add(jugador);

        var ronda = new RondaNormal(pregunta, jugadores);
        ronda.guardarRespuestas(jugador, pregunta.obtenerRespuestasCorrectas().stream().map(RespuestaDeJugador::new).collect(Collectors.toList()));
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
        ronda.guardarRespuestas(jugador, pregunta.obtenerRespuestasCorrectas().stream().map(RespuestaDeJugador::new).collect(Collectors.toList()));
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
    public void TestRondaNormalUtilizaMultiplicadorX2() throws NoQuedanUsosExcepcion {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearListaJugadores();

        var jugador = new Jugador("Test");
        jugadores.add(jugador);

        var ronda = new RondaNormal(pregunta, jugadores);
        ronda.usarModificador(jugador, jugador.obtenerMultiplicadorX2());
        ronda.guardarRespuestas(jugador, pregunta.obtenerRespuestasCorrectas().stream().map(RespuestaDeJugador::new).collect(Collectors.toList()));
        ronda.actualizarPuntaje();

        assertEquals(2, jugador.obtenerPuntaje());
    }

    @Test
    public void TestRondaNormalUtilizaMultiplicadorX3() throws NoQuedanUsosExcepcion {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearListaJugadores();

        var jugador = new Jugador("Test");
        jugadores.add(jugador);

        var ronda = new RondaNormal(pregunta, jugadores);
        ronda.usarModificador(jugador, jugador.obtenerMultiplicadorX3());
        ronda.guardarRespuestas(jugador, pregunta.obtenerRespuestasCorrectas().stream().map(RespuestaDeJugador::new).collect(Collectors.toList()));
        ronda.actualizarPuntaje();

        assertEquals(3, jugador.obtenerPuntaje());
    }

    @Test
    public void TestRondaExclusividadNoDaNadaSiGananLosDos() throws NoQuedanUsosExcepcion {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearListaJugadores();

        var jugador1 = new Jugador("Test1");
        var jugador2 = new Jugador("Test2");
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        var ronda = new RondaExclusividad(pregunta, jugadores);
        ronda.usarModificador(jugador1, jugador1.obtenerExclusividades());
        ronda.guardarRespuestas(jugador1, pregunta.obtenerRespuestasCorrectas().stream().map(RespuestaDeJugador::new).collect(Collectors.toList()));
        ronda.guardarRespuestas(jugador2, pregunta.obtenerRespuestasCorrectas().stream().map(RespuestaDeJugador::new).collect(Collectors.toList()));
        ronda.actualizarPuntaje();

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
    }

    @Test
    public void TestRondaExclusividadDaDobleSiGanaUno() throws NoQuedanUsosExcepcion {
        var pregunta = this.crearPregunta();
        var jugadores = this.crearListaJugadores();

        var jugador1 = new Jugador("Test1");
        var jugador2 = new Jugador("Test2");
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        var ronda = new RondaExclusividad(pregunta, jugadores);
        ronda.usarModificador(jugador1, jugador1.obtenerExclusividades());
        ronda.guardarRespuestas(jugador1, pregunta.obtenerRespuestasCorrectas().stream().map(RespuestaDeJugador::new).collect(Collectors.toList()));
        ronda.guardarRespuestas(jugador2, new ArrayList<>());
        ronda.actualizarPuntaje();

        assertEquals(2, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
    }
}
