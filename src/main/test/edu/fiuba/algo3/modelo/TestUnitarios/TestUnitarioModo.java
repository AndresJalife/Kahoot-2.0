package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.preguntas.ModoClasico;
import edu.fiuba.algo3.modelo.preguntas.ModoConPenalidad;
import edu.fiuba.algo3.modelo.preguntas.ModoPuntajeParcial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnitarioModo {

    @Test
    public void TestModoClasicoNoDaPuntajeSiNoTieneTodas() {
        var modo = new ModoClasico();
        assertEquals(0, modo.calcularPuntaje(5, 0, 4));
    }

    @Test
    public void TestModoClasicoDaPuntaConTodas() {
        var modo = new ModoClasico();
        assertEquals(1, modo.calcularPuntaje(5, 0, 5));
    }

    @Test
    public void modoClasicoResponderTodasBienYAdemas1MalDevuelve0() {
        var modo = new ModoClasico();
        assertEquals(0, modo.calcularPuntaje(2, 1, 2));
    }



    @Test
    public void TestModoConPenalidadRestaLasErroneas() {
        var modo = new ModoConPenalidad();
        assertEquals(1, modo.calcularPuntaje(5, 3, 4));
    }

    @Test
    public void TestModoParcialDaPuntajeParcial() {
        var modo = new ModoPuntajeParcial();
        assertEquals(4, modo.calcularPuntaje(5, 0, 4));
    }

    @Test
    public void TestModoParcialNoDaPuntajeParcialSiSeEquivoco() {
        var modo = new ModoPuntajeParcial();
        assertEquals(0, modo.calcularPuntaje(5, 1, 4));
    }
}
