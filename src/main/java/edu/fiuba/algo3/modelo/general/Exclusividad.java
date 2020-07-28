package edu.fiuba.algo3.modelo.general;

public class Exclusividad implements IModificador {
    private int cantUsos = 2;

    @Override
    public int obtenerCantidad(){
        return cantUsos;
    }

    @Override
    public Boolean quedanUsos(){
        return (cantUsos!=0);
    }

    @Override
    public void utilizar(){
        cantUsos--;
    }

    public int modificarPuntaje(int puntaje){
        return puntaje * 2;
    }
}
