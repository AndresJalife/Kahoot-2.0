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

    @Override
    public void utilizar() throws NoQuedanUsosExcepcion {
        if (usosDisponibles > 0) {
            usosDisponibles--;
        }
        else {
            throw new NoQuedanUsosExcepcion("No le quedan usos al multiplicador.");
        }
    }

    public int modificarPuntaje(int puntaje) throws NoQuedanUsosExcepcion {
        this.utilizar();
        return (puntaje * factor);
    }

    @Override
    public int obtenerCantidad(){
        return usosDisponibles;
    }

}
