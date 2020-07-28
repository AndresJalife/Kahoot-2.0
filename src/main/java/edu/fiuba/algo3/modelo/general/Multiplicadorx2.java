package edu.fiuba.algo3.modelo.general;

public class Multiplicadorx2 extends Multiplicador {
    private int Cantidad = Multiplicador.CondicionesIniciales;

    private final static int factor = 2;

    @Override
    public int modificarPuntaje(int puntaje) {
        return (puntaje * factor);
    }

    public int getCantidad(){ return Cantidad; }

    @Override
    public boolean UsarModificador(){
        if(Cantidad > 0){
            Cantidad --;
            return true;
        }
        return false;
    }

}

