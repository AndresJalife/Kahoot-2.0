package edu.fiuba.algo3.view.preguntas;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VistaVerdaderoYFalso extends StackPane {

    public VistaVerdaderoYFalso(){
        this.getChildren().clear();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label pregunta = new Label("7+8");
        grid.add(pregunta,1,1);
        Button opcionUno = new Button("San Martin");
        Button opcionDos = new Button("15");
        grid.add(opcionUno,1,2);
        grid.add(opcionDos,2,2);
        this.getChildren().addAll(grid);
    }
}
