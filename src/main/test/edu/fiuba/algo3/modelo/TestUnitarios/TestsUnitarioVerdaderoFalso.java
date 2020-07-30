package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.TipoVerdaderoYFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsUnitarioVerdaderoFalso {

    TipoVerdaderoYFalso verdaderoYFalso = new TipoVerdaderoYFalso();

    @Test
    public void opcionesValidaRecibeUnaListaCon2OpcionesYUnaEsCorrectaDevuelveTrue(){
        List<Opcion> opciones = new ArrayList<>();

        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso",true);
        opciones.add(opcion1);
        opciones.add(opcion2);

        assertTrue(verdaderoYFalso.opcionesValidas(opciones));
    }

    @Test
    public void opcionesValidaRecibeUnaListaDeOpcionesVaciaDevuelveFalse(){
        List<Opcion> opciones = new ArrayList<>();

        assertFalse(verdaderoYFalso.opcionesValidas(opciones));
    }

    @Test
    public void opcionesValidaRecibeUnaListaConDosOpcionesYSonCorrectasLas2DevuelveFalse(){
        List<Opcion> opciones = new ArrayList<>();

        Opcion opcion1 = new Opcion("Verdadero", true);
        Opcion opcion2 = new Opcion("Falso",true);
        opciones.add(opcion1);
        opciones.add(opcion2);

        assertFalse(verdaderoYFalso.opcionesValidas(opciones));
    }


}
