package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class PruebaAgregarPreguntas implements EventHandler<ActionEvent> {

    Kahoot miModelo;
    String miDireccion;

    public PruebaAgregarPreguntas(Kahoot modelo, String direccion){
        miModelo = modelo;
        miDireccion = direccion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            miModelo.inicializarPreguntas(getClass().getResource("/preguntas.json").toURI());

        }
        catch (Exception e){
            Alert fallo = new Alert(Alert.AlertType.ERROR);
            fallo.setHeaderText(String.format("La direccion del archivo no es valida %s", e.toString()));
            fallo.showAndWait();
        }
    }
}
