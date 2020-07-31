package edu.fiuba.algo3.modelo.general;

public class Multiplicador implements IModificador {

    private int usosDisponibles = 1;
    private int factor;

    public Boolean quedanUsos(){
        return (usosDisponibles !=0);
    }

    public Multiplicador(int factor) {
        this.factor = factor;
    }

    public void utilizar(){
        usosDisponibles -= 1;
    }

    public int modificarPuntaje(int puntaje) {

        return (puntaje * factor);
    }

    @Override
    public int obtenerCantidad(){
        return usosDisponibles;
    }

}
