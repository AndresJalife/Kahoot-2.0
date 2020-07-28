package edu.fiuba.algo3.modelo.general;

public class Exclusividad implements IModificador {

    private int Cantidad = Multiplicador.CondicionesIniciales;

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
