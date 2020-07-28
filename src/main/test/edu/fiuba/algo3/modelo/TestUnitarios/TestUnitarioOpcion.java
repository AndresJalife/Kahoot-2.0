package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.preguntas.Opcion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestUnitarioOpcion {

    @Test
    public void CrearOpcionyEsFalso(){
        Opcion opcion = new Opcion("");
        assertFalse(opcion.esCorrecta());
    }

    @Test
    public void CrearOpcionyAlDecirleQueEsLaRespuestaDaTrue(){
        Opcion opcion = new Opcion("", true);
        assertTrue(opcion.esCorrecta());
    }

    @Test
    public void MostrarTextoEscrito(){
        Opcion opcion = new Opcion("Hola", true);
        assertEquals("Hola", opcion.obtenerTexto());
    }

    @Test
    public void MostrarTextoEscritoPeroNoHayTexto(){
        Opcion opcion = new Opcion("", true);
        assertEquals("", opcion.obtenerTexto());
    }

    @Test
    public void MostrarTextoEscritoPeroEsNUll(){
        Opcion opcion = new Opcion(null, true);
        assertNull(null, opcion.obtenerTexto());
    }
}
