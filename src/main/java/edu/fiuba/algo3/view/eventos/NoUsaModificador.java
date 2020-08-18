package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.vistasGenerales.VistaMultiplicadores;
import edu.fiuba.algo3.view.vistasGenerales.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NoUsaModificador implements EventHandler<ActionEvent> {

    Kahoot miModelo;
    Jugador miJugador;
    Stage miStage;

    public NoUsaModificador(Kahoot modelo, Jugador jugador, Stage stage){
        miModelo = modelo;
        miJugador = jugador;
        miStage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Scene escena;
        if(miJugador == miModelo.obtenerPrimerJugador())
            escena = new Scene(new VistaMultiplicadores(miModelo, miStage, miModelo.obtenerSegundoJugador()));
        else
            escena = new Scene(new VistaPregunta(miModelo, miModelo.obtenerPrimerJugador(), miStage));
            escena.getStylesheets().add(getClass().getResource("/css/escenaGeneral.css").toExternalForm());
        miStage.setScene(escena);
    }
}
