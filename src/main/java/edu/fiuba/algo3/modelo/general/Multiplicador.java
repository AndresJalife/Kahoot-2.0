package edu.fiuba.algo3.modelo.general;

public abstract class Multiplicador implements IModificador {

    private int cantUsos = IModificador.CondicionesIniciales;

    public Boolean quedanUsos(){
        return (cantUsos!=0);
    }

    public void utilizar(){
        cantUsos -= 1;
    }

    public abstract int modificarPuntaje(int puntaje);

    public int getCantidad(){ return cantUsos; }

}
