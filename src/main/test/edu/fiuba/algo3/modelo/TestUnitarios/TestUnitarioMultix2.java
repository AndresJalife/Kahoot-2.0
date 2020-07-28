package edu.fiuba.algo3.modelo.TestUnitarios;
import edu.fiuba.algo3.modelo.Multiplicadorx2;
import edu.fiuba.algo3.modelo.Multiplicadorx3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUnitarioMultix2 {


    @Test
    public void CrearMultiplicadorx2YVerificarQueQuedenUsos(){
        Multiplicadorx2 x2= new Multiplicadorx2();
        assertTrue(x2.quedanUsos());
    }

    @Test
    public void CrearMultiplicadorx2YVerificarQueElFactorEs2(){
        Multiplicadorx2 x2= new Multiplicadorx2();
        assertTrue(x2.obtenerFactor()==2);
    }

}
