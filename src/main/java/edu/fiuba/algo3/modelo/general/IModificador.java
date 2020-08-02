package edu.fiuba.algo3.modelo.general;

public interface IModificador {

    void utilizar() throws NoQuedanUsosExcepcion;
    int obtenerCantidad();
    Boolean quedanUsos();
}
