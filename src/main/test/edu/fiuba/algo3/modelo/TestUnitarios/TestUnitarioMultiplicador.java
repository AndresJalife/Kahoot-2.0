package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.general.Multiplicadorx2;
import edu.fiuba.algo3.modelo.general.Multiplicadorx3;
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
    public void CrearMultiplicadorx2YVerificarQueModificaCorrectamenteUnPuntaje(){
        Multiplicador x2= new Multiplicador(2);
        int puntaje = 3;
        assertEquals(6, x2.modificarPuntaje(puntaje));
    }

    @Test
    public void CrearMultiplicadorx3YVerificarQueModificaCorrectamenteUnPuntajePositivo(){
        Multiplicador x3= new Multiplicador(3);
        int puntaje = 3;
        assertEquals(9, x3.modificarPuntaje(puntaje));
    }

    @Test
    public void CrearMultiplicadorx2YVerificarQueModificaCorrectamenteUnPuntajeNegativo(){
        Multiplicador x2= new Multiplicador(2);
        int puntaje = -4;
        assertEquals(-8, x2.modificarPuntaje(puntaje));
    }

    @Test
    public void UtilizoElMultiplicadorYNoLeQuedanUsos(){
        Multiplicador x2= new Multiplicador(2);
        x2.utilizar();
        assertFalse(x2.quedanUsos());
    }
}
