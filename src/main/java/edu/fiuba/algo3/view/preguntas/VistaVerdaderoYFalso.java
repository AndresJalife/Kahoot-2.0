package edu.fiuba.algo3.view.preguntas;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VistaVerdaderoYFalso extends StackPane {

    public VistaVerdaderoYFalso(){
        Label pregunta = new Label("Llego a VYF");
        Scene escena = new Scene(pregunta, 200,1000);
        this.getChildren().addAll(pregunta);
    }
}
