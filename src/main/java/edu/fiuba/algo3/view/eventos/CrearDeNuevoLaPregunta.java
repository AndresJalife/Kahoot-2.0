package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class CrearDeNuevoLaPregunta implements EventHandler<ActionEvent>{

    Kahoot miModelo;
    Jugador miJugador;
    Stage miStage;

    public CrearDeNuevoLaPregunta(Kahoot modelo, Jugador jugador, Stage stage){
        miModelo = modelo;
        miJugador = jugador;
        miStage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
