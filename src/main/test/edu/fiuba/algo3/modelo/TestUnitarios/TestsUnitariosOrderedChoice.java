package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.RespuestaDeJugador;
import edu.fiuba.algo3.modelo.preguntas.TipoOrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsUnitariosOrderedChoice {
    TipoOrderedChoice orderedChoice = new TipoOrderedChoice();
    List<Opcion> opciones = new ArrayList<>();
    List<RespuestaDeJugador> respuestasJugador = new ArrayList<>();
    Opcion opcion1 = new Opcion("1");
    Opcion opcion2 = new Opcion("2");
    Opcion opcion3 = new Opcion("3");
    Opcion opcion4 = new Opcion("4");

    @Test
    public void cantCorrectasRecibeLas4OpcionesEnElOrdenCorrectoDevuelve4(){
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        respuestasJugador.addAll(opciones.stream().map(RespuestaDeJugador::new).collect(Collectors.toList()));
        assertEquals(4,orderedChoice.cantCorrectas(opciones,respuestasJugador));
    }

    @Test
    public void cantCorrectasRecibe2OpcionesEnElOrdenCorrectoDevuelve2(){
        opciones.add(opcion2);
        opciones.add(opcion1);
        opciones.add(opcion3);
        opciones.add(opcion4);

        respuestasJugador.add(new RespuestaDeJugador(opcion1));
        respuestasJugador.add(new RespuestaDeJugador(opcion2));
        respuestasJugador.add(new RespuestaDeJugador(opcion4));
        respuestasJugador.add(new RespuestaDeJugador(opcion3));

        assertEquals(2, orderedChoice.cantCorrectas(opciones,respuestasJugador));
    }

    @Test
    public void cantCorrectasRecibe1OpcionCorrectaDevuelve1(){
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        respuestasJugador.add(new RespuestaDeJugador(opcion1));

        assertEquals(1,orderedChoice.cantCorrectas(opciones,respuestasJugador));
    }
}
