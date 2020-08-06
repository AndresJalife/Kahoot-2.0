package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.TipoOrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsUnitariosOrderedChoice {
    TipoOrderedChoice orderedChoice = new TipoOrderedChoice();
    List<Opcion> opciones = new ArrayList<>();
    List<Opcion> respuestasJugador = new ArrayList<>();
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

        respuestasJugador.addAll(opciones);
        assertEquals(4,orderedChoice.cantCorrectas(opciones,respuestasJugador));
    }

    @Test
    public void cantCorrectasRecibe2OpcionesEnElOrdenCorrectoDevuelve2(){
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        respuestasJugador.add(opcion1);
        respuestasJugador.add(opcion2);
        respuestasJugador.add(opcion4);
        respuestasJugador.add(opcion3);

        assertEquals(2,orderedChoice.cantCorrectas(opciones,respuestasJugador));
    }

    @Test
    public void cantCorrectasRecibe1OpcionCorrectaDevuelve1(){
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        respuestasJugador.add(opcion1);

        assertEquals(1,orderedChoice.cantCorrectas(opciones,respuestasJugador));
    }
}
