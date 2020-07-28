package edu.fiuba.algo3.modelo.TestUnitarios;

public class TestUnitarioModo {
    @Test
    public void TestModoClasicoNoDaPuntajeSiNoTieneTodas() {
        var modo = new ModoClasico();
        assertEquals(0, modo.calcularPuntaje(5, 0, 4));
    }

    @Test
    public void TestModoClasicoDaPuntaConTodas() {
        var modo = new ModoClasico();
        assertEquals(5, modo.calcularPuntaje(5, 0, 5));
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
