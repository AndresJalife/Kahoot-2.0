package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.view.eventos.TerminarRonda;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VistaTerminar extends StackPane {

    GridPane grid;

    public VistaTerminar(Kahoot modelo, Stage stage){
        this.getChildren().clear();
        this.crearGrid();
        this.obtenerBotonTerminar(grid,modelo, stage);
    }

    private void crearGrid(){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
    }

    private void obtenerBotonTerminar(GridPane grid, Kahoot modelo, Stage stage){
        Button boton = new Button("Terminar");
        boton.setOnAction(new TerminarRonda(modelo, stage));
        grid.add(boton,1,1);
        this.getChildren().addAll(grid);

    }
}
