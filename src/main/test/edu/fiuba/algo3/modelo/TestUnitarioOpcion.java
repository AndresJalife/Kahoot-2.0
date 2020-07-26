package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUnitarioOpcion {

    @Test
    public void CrearOpcionyEsFalso(){
        Opcion opcion = new Opcion("");
        assertFalse(opcion.Respuesta());
    }

    @Test
    public void CrearOpcionyAlDecirleQueEsLaRespuestaDaTrue(){
        Opcion opcion = new Opcion("");
        opcion.Opcion_Correcta();
        assertTrue(opcion.Respuesta());
    }
}
