package edu.fiuba.algo3.modelo.general;

public abstract class Multiplicador implements IModificador {

    private int cantUsos=1;

    public Boolean quedanUsos(){
        return (cantUsos!=0);
    }

    public void utilizar(){
        cantUsos -= 1;
    }

    public abstract int modificarPuntaje(int puntaje);



}
