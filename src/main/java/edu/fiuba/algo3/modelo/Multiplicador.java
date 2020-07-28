package edu.fiuba.algo3.modelo;

public class Multiplicador implements IModificador {

    private int cantUsos=1;

    public Boolean quedanUsos(){
        return (cantUsos!=0);
    }

}
