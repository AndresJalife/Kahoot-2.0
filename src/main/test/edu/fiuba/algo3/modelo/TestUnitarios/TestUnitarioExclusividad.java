package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.excepciones.NoQuedanUsosExcepcion;
import edu.fiuba.algo3.modelo.general.Exclusividad;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUnitarioExclusividad {

    @Test
    public void TestExclusividadTiraExcepcionSiNoQuedanUsos() throws NoQuedanUsosExcepcion {
        var exclusividad = new Exclusividad(1);
        exclusividad.utilizar();
        assertThrows(NoQuedanUsosExcepcion.class, exclusividad::utilizar);
    }

    @Test
    public void TestExclusividadNoQuedanUsos() throws NoQuedanUsosExcepcion {
        var exclusividad = new Exclusividad(1);
        exclusividad.utilizar();
        assertFalse(exclusividad.quedanUsos());
    }

    @Test
    public void TestExclusividadModificaElPuntajeCorrectamente() throws NoQuedanUsosExcepcion {
        var exclusividad = new Exclusividad(2);
        assertEquals(20, exclusividad.modificarPuntaje(10));
    }

    @Test
    public void TestExclusividadSeGasta() throws NoQuedanUsosExcepcion {
        var exclusividad = new Exclusividad(2);
        exclusividad.utilizar();
        assertEquals(1, exclusividad.obtenerCantidad());
    }

    @Test
    public void TestExclusividadSeInicializaConUsosCorrectamente() {
        var exclusividad = new Exclusividad(10);
        assertEquals(10, exclusividad.obtenerCantidad());
    }
}
