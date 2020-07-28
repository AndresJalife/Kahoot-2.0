package edu.fiuba.algo3.modelo.general;

public class Exclusividad implements IModificador {
    private static int cantidadRestante;

    public Exclusividad(){

        cantidadRestante = 2;
    }

    public void utilizar(){

        cantidadRestante -= 1;
    }

    public static int obtenerCantidad(){

        return cantidadRestante;
    }

    public static int condicionesIniciales = 2;  // ?????
}
