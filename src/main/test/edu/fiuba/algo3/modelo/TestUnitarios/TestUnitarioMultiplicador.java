package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.general.Multiplicador;
import edu.fiuba.algo3.modelo.general.NoQuedanUsosExcepcion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUnitarioMultiplicador {

    @Test
    public void CrearMultiplicadorx2YVerificarQueQuedenUsos(){
        Multiplicador x2= new Multiplicador(2);
        assertTrue(x2.quedanUsos());
    }

    @Test
    public void CrearMultiplicadorx3YVerificarQueQuedenUsos(){
        Multiplicador x3= new Multiplicador(3);
        assertTrue(x3.quedanUsos());
    }

    @Test
    public void CrearMultiplicadorx2YVerificarQueModificaCorrectamenteUnPuntaje() throws NoQuedanUsosExcepcion {
        Multiplicador x2= new Multiplicador(2);
        int puntaje = 3;
        assertEquals(6, x2.modificarPuntaje(puntaje));
    }

    @Test
    public void CrearMultiplicadorx3YVerificarQueModificaCorrectamenteUnPuntajePositivo() throws NoQuedanUsosExcepcion {
        Multiplicador x3= new Multiplicador(3);
        int puntaje = 3;
        assertEquals(9, x3.modificarPuntaje(puntaje));
    }

    @Test
    public void CrearMultiplicadorx2YVerificarQueModificaCorrectamenteUnPuntajeNegativo() throws NoQuedanUsosExcepcion {
        Multiplicador x2= new Multiplicador(2);
        int puntaje = -4;
        assertEquals(-8, x2.modificarPuntaje(puntaje));
    }

    @Test
    public void UtilizoElMultiplicadorYNoLeQuedanUsos() throws NoQuedanUsosExcepcion {
        Multiplicador x2= new Multiplicador(2);
        x2.utilizar();
        assertFalse(x2.quedanUsos());
    }
}
