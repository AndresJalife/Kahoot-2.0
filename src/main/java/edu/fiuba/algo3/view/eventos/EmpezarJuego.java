package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.VistaMultiplicadores;
import edu.fiuba.algo3.view.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmpezarJuego implements EventHandler<ActionEvent> {

    TextField usuario1;
    TextField usuario2;
    Kahoot miModelo;
    Stage miStage;

    public EmpezarJuego(TextField jugador1, TextField jugador2, Kahoot modelo, Stage stage){
        usuario1 = jugador1;
        usuario2 = jugador2;
        miModelo = modelo;
        miStage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(VerificarUsuarios(usuario1, usuario2)){
            miModelo.agregarJugador(usuario1.getText());
            miModelo.agregarJugador(usuario2.getText());
//            Scene escenaPregunta = new Scene(new VistaPregunta(miModelo, miModelo.obtenerJugadores().get(0), miStage));
//            miStage.setScene(escenaPregunta);
//            for (Jugador jugador: miModelo.obtenerJugadores()){
//
//            }
            miModelo.comenzar();
            Scene escenaMultiplicador = new Scene(new VistaMultiplicadores(miModelo, miStage));
            miStage.setScene(escenaMultiplicador);
//           HACER UN FOR DE JUGADORES EN VEZ DE LO DE ARRIBA
        }
        else{
            Alert fallo = new Alert(Alert.AlertType.ERROR);
            fallo.setHeaderText("Los nombres de los usuarios deben ser distintos de vacio");
            fallo.showAndWait();
        }
    }

    private boolean VerificarUsuarios(TextField usuarioUno,TextField usuarioDos){
        return  !usuarioDos.getText().trim().isEmpty() && !usuarioUno.getText().trim().isEmpty();
    }
}
