package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.VistaRespuestas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TerminarRonda implements EventHandler<ActionEvent> {

    Kahoot miModelo;
    Stage miStage;

    public TerminarRonda(Kahoot modelo, Stage stage){
        miModelo = modelo;
        miStage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaRespuestas vistaRespuesta = new VistaRespuestas(miModelo, miStage);
        Scene escena = new Scene(vistaRespuesta);
        miStage.setScene(escena);
    }
}
