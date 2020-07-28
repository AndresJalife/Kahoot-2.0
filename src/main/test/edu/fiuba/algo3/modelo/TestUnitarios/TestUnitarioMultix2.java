package edu.fiuba.algo3.modelo.TestUnitarios;
import edu.fiuba.algo3.modelo.general.Multiplicadorx2;
import edu.fiuba.algo3.modelo.general.Multiplicadorx3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnitarioMultix2 {


    @Test
    public void CrearMultiplicadorx2YVerificarQueQuedenUsos(){
        Multiplicadorx2 x2= new Multiplicadorx2();
        assertTrue(x2.quedanUsos());
    }

    @Test
    public void CrearMultiplicadorx2YVerificarQueModificaCorrectamenteUnPuntaje(){
        Multiplicadorx2 x2= new Multiplicadorx2();
        int puntaje = 3;
        assertEquals(-6, x2.modificarPuntaje(puntaje));
    }

    @Test
    public void CrearMultiplicadorx2YVerificarQueModificaCorrectamenteUnPuntajeNegativo(){
        Multiplicadorx2 x2= new Multiplicadorx2();
        int puntaje = -4;
        assertEquals(-8, x2.modificarPuntaje(puntaje));
    }

    @Test
    public void UtilizoElMultiplicadorYNoLeQuedanUsos(){
        Multiplicadorx2 x2= new Multiplicadorx2();
        x2.utilizar();
        assertFalse(x2.quedanUsos());
    }

}
