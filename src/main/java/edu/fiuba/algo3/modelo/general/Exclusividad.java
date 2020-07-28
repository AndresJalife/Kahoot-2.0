package edu.fiuba.algo3.modelo.general;

public class Exclusividad implements IModificador {

    private int Cantidad = Multiplicador.CondicionesIniciales;

    public int getCantidad(){ return Cantidad; }

    public void utilizar(){
        Cantidad--;
    }
}
