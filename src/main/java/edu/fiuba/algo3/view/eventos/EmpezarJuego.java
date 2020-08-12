package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class EmpezarJuego implements EventHandler<ActionEvent> {

    String usuario1;
    String usuario2;
    Kahoot miModelo;
    Stage miStage;

    public EmpezarJuego(String jugador1, String jugador2, Kahoot modelo, Stage stage){
        usuario1 = jugador1;
        usuario2 = jugador2;
        miModelo = modelo;
        miStage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(VerificarUsuarios(usuario1, usuario2)){
            miModelo.agregarJugador(usuario1);
            miModelo.agregarJugador(usuario2);
            Scene escenaPregunta = new Scene(new VistaPregunta(miModelo, miModelo.obtenerJugadores().get(0)));
            miStage.setScene(escenaPregunta);
        }
        else{
            Alert fallo = new Alert(Alert.AlertType.ERROR);
            fallo.setHeaderText("Los nombres de los usuarios deben ser distintos de vacio");
            fallo.showAndWait();
        }
    }

    private boolean VerificarUsuarios(String usuarioUno, String usuarioDos){
        return !usuarioDos.isEmpty() && !usuarioUno.isEmpty();
    }
}
