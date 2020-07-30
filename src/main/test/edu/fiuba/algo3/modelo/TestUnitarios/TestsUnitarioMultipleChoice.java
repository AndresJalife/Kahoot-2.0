package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.TipoMultipleChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsUnitarioMultipleChoice {

    TipoMultipleChoice multipleChoice = new TipoMultipleChoice();

    @Test
    public void opcionesValidasRecibeUnaListaDeOpcionesVaciaDevuelveFalse(){
        List<Opcion> opciones = new ArrayList<>();

        assertFalse(multipleChoice.opcionesValidas(opciones));
    }

    @Test
    public void opcionesValidasRecibeUnaListaConUnaOpcionDevuelveFalse(){
        List<Opcion> opciones = new ArrayList<>();

        Opcion opcion1 = new Opcion("opcion1", true);
        opciones.add(opcion1);

        assertFalse(multipleChoice.opcionesValidas(opciones));
    }

    @Test
    public void opcionesValidasRecibeUnaListaCon6OpcionesDevuelveFalse(){
        List<Opcion> opciones = new ArrayList<>();

        Opcion opcion1 = new Opcion("opcion1", true);
        Opcion opcion2 = new Opcion("opcion2", true);
        Opcion opcion3 = new Opcion("opcion3", true);
        Opcion opcion4 = new Opcion("opcion4", true);
        Opcion opcion5 = new Opcion("opcion5", true);
        Opcion opcion6 = new Opcion("opcion6", true);

        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opciones.add(opcion5);
        opciones.add(opcion6);

        assertFalse(multipleChoice.opcionesValidas(opciones));
    }

    @Test
    public void opcionesValidasRecibeUnaListaCon2OpcionesYNingunaEsCorrectaDevuelveFalse(){
        List<Opcion> opciones = new ArrayList<>();

        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        opciones.add(opcion1);
        opciones.add(opcion2);

        assertFalse(multipleChoice.opcionesValidas(opciones));
    }


    @Test
    public void opcionesValidasRecibeUnaListaCon2OpcionesYUnaEsCorrectaDevuelveTrue(){
        List<Opcion> opciones = new ArrayList<>();

        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2",true);
        opciones.add(opcion1);
        opciones.add(opcion2);

        assertTrue(multipleChoice.opcionesValidas(opciones));
    }


    @Test
    public void opcionesValidasRecibeUnaListaConDosOpcionesYSonCorrectasLas2DevuelveTrue(){
        List<Opcion> opciones = new ArrayList<>();

        Opcion opcion1 = new Opcion("opcion1", true);
        Opcion opcion2 = new Opcion("opcion2",true);
        opciones.add(opcion1);
        opciones.add(opcion2);

        assertTrue(multipleChoice.opcionesValidas(opciones));
    }

}
