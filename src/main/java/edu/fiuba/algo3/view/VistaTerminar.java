package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VistaTerminar extends StackPane {
    public VistaTerminar(Kahoot modelo, Stage stage){
        this.getChildren().clear();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Button boton = new Button("Terminar");
        boton.setOnAction(actionEvent -> {
            this.getChildren().clear();
            VistaRespuestas vistaRespuesta = new VistaRespuestas(modelo, stage);
            this.getChildren().addAll(vistaRespuesta);
        });
        grid.add(boton,1,1);
        this.getChildren().addAll(grid);
    }
}
