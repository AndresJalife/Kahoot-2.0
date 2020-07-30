package edu.fiuba.algo3.modelo.general;

public abstract class Multiplicador implements IModificador {

    private int usosDisponibles = 1;

    public Boolean quedanUsos(){
        return (usosDisponibles !=0);
    }

    @Override
    public void utilizar(){
        usosDisponibles -= 1;
    }

    public abstract int modificarPuntaje(int puntaje);

    @Override
    public int obtenerCantidad(){
        return usosDisponibles;
    }

}
