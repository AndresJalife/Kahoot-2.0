package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.VistaMenu;
import edu.fiuba.algo3.view.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class SiguienteRondaOTerminar implements EventHandler<ActionEvent> {

    Kahoot miModelo;
    Stage miStage;

    public SiguienteRondaOTerminar(Kahoot modelo, Stage stage){
        miModelo = modelo;
        miStage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaPregunta vistaPregunta = new VistaPregunta();
        vistaPregunta.VistaPreguntaSiguiente(miModelo, miModelo.obtenerJugadores().get(0),miStage);
        Scene escena = new Scene(vistaPregunta);
        miStage.setScene(escena);
    }
}
