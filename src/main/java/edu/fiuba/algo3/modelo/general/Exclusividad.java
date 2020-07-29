package edu.fiuba.algo3.modelo.general;

public class Exclusividad implements IModificador {
    private int usosDisponibles = 2;

    @Override
    public int obtenerCantidad(){
        return usosDisponibles;
    }

    @Override
    public Boolean quedanUsos(){
        return (usosDisponibles !=0);
    }

    @Override
    public void utilizar(){
        usosDisponibles--;
    }

    public int modificarPuntaje(int puntaje){
        return puntaje * 2;
    }
}
