package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.vistasGenerales.VistaPregunta;
import edu.fiuba.algo3.view.vistasPreguntas.FabricaDeVistasPregunta;
import edu.fiuba.algo3.view.vistasPreguntas.VistaTipoDePregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class ReCrearLaPregunta implements EventHandler<ActionEvent> {

    Stage miStage;
    FabricaDeVistasPregunta miFabrica;
    Kahoot miModelo;
    Jugador miJugador;

    public ReCrearLaPregunta(Stage stage , Kahoot modelo, Jugador jugador){
        miStage = stage;
        miFabrica = new FabricaDeVistasPregunta();
        miModelo = modelo;
        miJugador = jugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        AudioClip sonidoBoton = new AudioClip(this.getClass().getResource("/sonidos/botonClick.mp3").toExternalForm());
        sonidoBoton.setVolume(100);
        sonidoBoton.play();
        var vistaPregunta = new VistaPregunta(miModelo, miJugador, miStage);
        Scene escena = new Scene(vistaPregunta);
        escena.getStylesheets().add(getClass().getResource("/css/escenaGeneral.css").toExternalForm());
        miStage.setScene(escena);
    }
}
