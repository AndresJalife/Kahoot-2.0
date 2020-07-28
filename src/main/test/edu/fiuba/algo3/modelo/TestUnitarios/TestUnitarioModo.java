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

}
