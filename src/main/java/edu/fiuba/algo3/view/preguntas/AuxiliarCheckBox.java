package edu.fiuba.algo3.view.preguntas;

import edu.fiuba.algo3.modelo.preguntas.Opcion;
import javafx.scene.control.CheckBox;

public class AuxiliarCheckBox {
    CheckBox caja;
    Opcion miOpcion;

    public AuxiliarCheckBox(CheckBox checkBox, Opcion opcion){
        caja = checkBox;
        miOpcion = opcion;
    }

    public Opcion obtenerOpcion(){ return miOpcion; }

    public CheckBox obtenerCheckBox(){ return caja; }
}
