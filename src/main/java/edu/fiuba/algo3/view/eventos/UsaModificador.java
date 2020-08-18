package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.IModificador;
import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.VistaMultiplicadores;
import edu.fiuba.algo3.view.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UsaModificador implements EventHandler<ActionEvent> {

    Kahoot miModelo;
    Jugador miJugador;
    IModificador miModificador;
    Stage miStage;

    public UsaModificador(Kahoot modelo, Jugador jugador, IModificador modificador, Stage stage){
        miModelo = modelo;
        miJugador = jugador;
        miModificador = modificador;
        miStage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        miModelo.utilizarModificador(miJugador, miModificador);
        Scene escena;
        if(miJugador == miModelo.obtenerPrimerJugador())
            escena = new Scene(new VistaMultiplicadores(miModelo, miStage, miModelo.obtenerSegundoJugador()));
        else
            escena = new Scene(new VistaPregunta(miModelo, miModelo.obtenerPrimerJugador(), miStage));
        miStage.setScene(escena);
    }
}
