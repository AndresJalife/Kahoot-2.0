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
        if(miModelo.cambiarRonda()){
            VistaPregunta vistaPregunta = new VistaPregunta();
            vistaPregunta.VistaPreguntaSiguiente(miModelo, miModelo.obtenerJugadores().get(0),miStage);
            Scene escena = new Scene(vistaPregunta);
            miStage.setScene(escena);
        }
        else{
            List<Jugador> jugadores = new ArrayList<>(miModelo.obtenerJugadores());
            miModelo.actualizarPuntaje();
            jugadores.sort((o1, o2) -> Integer.compare(o2.obtenerPuntaje(), o1.obtenerPuntaje()));
            Alert ganador = new Alert(Alert.AlertType.INFORMATION);
            ganador.setHeaderText("El ganador es : " + jugadores.get(0).obtenerNombre());
            ganador.showAndWait();
            System.exit(0);
//            VistaMenu vistaMenu = new VistaMenu(nuevoKahoot, nuevaStage);
//            Scene escena = new Scene(vistaMenu);
//            miStage.setScene(escena);
        }
    }
}
