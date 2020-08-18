package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.excepciones.NoQuedanUsosExcepcion;
import edu.fiuba.algo3.modelo.general.IModificador;
import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.vistasGenerales.VistaMultiplicadores;
import edu.fiuba.algo3.view.vistasGenerales.VistaPregunta;
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
        try {
            miModelo.utilizarModificador(miJugador, miModificador);
        } catch (NoQuedanUsosExcepcion noQuedanUsosExcepcion) {
            noQuedanUsosExcepcion.printStackTrace();
        }
        Scene escena;
        if(miJugador == miModelo.obtenerPrimerJugador())
            escena = new Scene(new VistaMultiplicadores(miModelo, miStage, miModelo.obtenerSegundoJugador()));
        else
            escena = new Scene(new VistaPregunta(miModelo, miModelo.obtenerPrimerJugador(), miStage));
            escena.getStylesheets().add(getClass().getResource("/css/escenaInicial.css").toExternalForm());
        miStage.setScene(escena);
    }
}
