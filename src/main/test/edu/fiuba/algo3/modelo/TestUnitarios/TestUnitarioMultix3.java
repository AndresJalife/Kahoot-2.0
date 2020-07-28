package edu.fiuba.algo3.modelo.TestUnitarios;
import edu.fiuba.algo3.modelo.general.Multiplicadorx3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUnitarioMultix3 {


    @Test
    public void CrearMultiplicadorx3YVerificarQueQuedenUsos(){
        Multiplicadorx3 x3= new Multiplicadorx3();
        assertTrue(x3.quedanUsos());
    }

    @Test
    public void CrearMultiplicadorx3YVerificarQueModificaCorrectamenteUnPuntajePositivo(){
        Multiplicadorx3 x3= new Multiplicadorx3();
        int puntaje = 3;
        assertTrue(x3.modificarPuntaje(puntaje) == 9);
    }

    @Test
    public void CrearMultiplicadorx3YVerificarQueModificaCorrectamenteUnPuntajeNegativo(){
        Multiplicadorx3 x3= new Multiplicadorx3();
        int puntaje = -4;
        assertTrue(x3.modificarPuntaje(puntaje) == -12);
    }

    @Test
    public void UtilizoElMultiplicadorYNoLeQuedanUsos(){
        Multiplicadorx3 x3= new Multiplicadorx3();
        x3.utilizar();
        assertFalse(!x3.quedanUsos());
    }
}
