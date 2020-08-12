package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.excepciones.NoQuedanUsosExcepcion;

public interface IModificador {

    void utilizar() throws NoQuedanUsosExcepcion;
    int obtenerCantidad();
    Boolean quedanUsos();
}
