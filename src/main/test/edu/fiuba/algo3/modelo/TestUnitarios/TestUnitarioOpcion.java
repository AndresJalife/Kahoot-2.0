package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.Opcion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

    @Test
    public void MostrarTextoEscrito(){
        Opcion opcion = new Opcion("Hola");
        opcion.Opcion_Correcta();
        assertEquals("Hola", opcion.obtenerTextoamostrar());
    }

    @Test
    public void MostrarTextoEscritoPeroNoHayTexto(){
        Opcion opcion = new Opcion("");
        opcion.Opcion_Correcta();
        assertEquals("", opcion.obtenerTextoamostrar());
    }

    @Test
    public void MostrarTextoEscritoPeroEsNUll(){
        Opcion opcion = new Opcion(null);
        opcion.Opcion_Correcta();
        assertNull(null, opcion.obtenerTextoamostrar());
    }
}
