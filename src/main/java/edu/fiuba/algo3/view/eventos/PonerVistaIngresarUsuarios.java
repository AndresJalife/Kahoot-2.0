package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.vistasGenerales.VistaIngresarUsuarios;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
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
        AudioClip sonidoBoton = new AudioClip(this.getClass().getResource("/sonidos/botonClick.mp3").toExternalForm());
        sonidoBoton.setVolume(100);
        sonidoBoton.play();
        Scene escenaPregunta = new Scene(new VistaIngresarUsuarios(miModelo, miStage));
        escenaPregunta.getStylesheets().add(getClass().getResource("/css/escenaGeneral.css").toExternalForm());
        miStage.setScene(escenaPregunta);
    }
}
