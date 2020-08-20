package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.vistasGenerales.VistaMultiplicadores;
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

    public EmpezarJuego(TextField jugador1, TextField jugador2, Kahoot modelo, Stage stage) {
        usuario1 = jugador1;
        usuario2 = jugador2;
        miModelo = modelo;
        miStage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        verificarUsuarios(usuario1, usuario2);
        miModelo.agregarJugador(usuario1.getText());
        miModelo.agregarJugador(usuario2.getText());
        miModelo.comenzar();

        VistaMultiplicadores vistaMultiplicadores = new VistaMultiplicadores(miModelo, miStage, miModelo.obtenerPrimerJugador());
        Scene escenaMultiplicador = new Scene(vistaMultiplicadores);
        miStage.setScene(escenaMultiplicador);
    }

    private void verificarUsuarios(TextField usuarioUno, TextField usuarioDos) {
        if (usuarioUno.getText().trim().isEmpty()) {
            usuarioUno.setText("Jugador 1");
        }
        if (usuarioDos.getText().trim().isEmpty()) {
            usuarioDos.setText("Jugador 2");
        }
    }
}
