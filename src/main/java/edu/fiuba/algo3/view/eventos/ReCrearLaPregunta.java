package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.view.VistaPregunta;
import edu.fiuba.algo3.view.preguntas.FabricaDeVistasPregunta;
import edu.fiuba.algo3.view.preguntas.VistaTipoDePregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReCrearLaPregunta implements EventHandler<ActionEvent> {

    Stage miStage;
    Kahoot miModelo;
    Jugador miJugador;

    public ReCrearLaPregunta(Stage stage , Kahoot modelo, Jugador jugador){
        miStage = stage;
        miModelo = modelo;
        miJugador = jugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        var vistaPregunta = new VistaPregunta(miModelo, miJugador, miStage);
        var escena = new Scene(vistaPregunta);
        escena.getStylesheets().add(getClass().getResource("/css/escenaPregunta.css").toExternalForm());
        miStage.setScene(escena);
    }
}
