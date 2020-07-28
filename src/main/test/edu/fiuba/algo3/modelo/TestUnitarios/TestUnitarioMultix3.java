package edu.fiuba.algo3.modelo.TestUnitarios;
import edu.fiuba.algo3.modelo.Multiplicadorx3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUnitarioMultix3 {


    @Test
    public void CrearMultiplicadorx2YVerificarQueQuedenUsos(){
        Multiplicadorx3 x3= new Multiplicadorx3();
        assertTrue(x3.quedanUsos());
    }

}
