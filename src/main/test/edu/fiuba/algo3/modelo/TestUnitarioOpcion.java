package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestUnitarioOpcion {

    @Test
    public void CrearOpcionyEsFalso(){
        Opcion opcion = new Opcion("");
        assertFalse(opcion.Respuesta());
    }
}
