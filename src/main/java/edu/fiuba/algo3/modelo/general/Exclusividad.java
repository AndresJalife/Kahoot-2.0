package edu.fiuba.algo3.modelo.general;

public class Exclusividad implements IModificador {
    private int Cantidad;

    public static int CondicionesIniciales = 2;

    public int obtenerCantidad(){ return Cantidad; }

    @Override
    public void utilizar(){ Cantidad--; }
}
