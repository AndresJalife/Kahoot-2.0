package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.VistaIngresarUsuarios;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PonerVistaIngresarUsuarios implements EventHandler<ActionEvent> {

    Kahoot miModelo;
    Stage miStage;

    public PonerVistaIngresarUsuarios(Kahoot modelo, Stage stage){
        miModelo = modelo;
        miStage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Scene escenaPregunta = new Scene(new VistaIngresarUsuarios(miModelo, miStage));
        escenaPregunta.getStylesheets().add(getClass().getResource("/css/escenaPregunta.css").toExternalForm());
        miStage.setScene(escenaPregunta);
    }
}
