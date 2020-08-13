package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.preguntas.VistaVerdaderoYFalso;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VistaCambiarJugador extends StackPane {

    GridPane grid;

    public VistaCambiarJugador(Kahoot modelo, Jugador jugador, Stage stage){
        this.getChildren().clear();
        this.crearGrid();

        Button boton = new Button("Siguiente jugador");
        boton.setOnAction(actionEvent -> {
            this.getChildren().clear();
            VistaVerdaderoYFalso vistaVerdaderoYFalso = new VistaVerdaderoYFalso(modelo, jugador, stage);
            this.getChildren().addAll(vistaVerdaderoYFalso);
            });
        grid.add(boton,1,1);
        this.getChildren().addAll(grid);
    }

    private void crearGrid(){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
    }
}
