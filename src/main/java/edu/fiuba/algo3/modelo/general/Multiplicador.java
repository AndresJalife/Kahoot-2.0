package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.excepciones.NoQuedanUsosExcepcion;

public class Multiplicador implements IModificador {

    private int usosDisponibles = 1;
    private Integer factor;

    public Boolean quedanUsos(){
        return (usosDisponibles !=0);
    }

    public Multiplicador(int factor) {
        this.factor = factor;
    }

    @Override
    public void utilizar() throws NoQuedanUsosExcepcion {
        if (usosDisponibles <= 0) {
            throw new NoQuedanUsosExcepcion("No le quedan usos al multiplicador.");
        }
        else {
            usosDisponibles--;
        }
    }

    public int modificarPuntaje(int puntaje){
        return (puntaje * factor);
    }

    @Override
    public int obtenerCantidad(){
        return usosDisponibles;
    }

    @Override
    public String obtenerNombre() {
        return 'X' + factor.toString();
    }

}
