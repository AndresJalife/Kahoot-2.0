package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.eventos.ReCrearLaPregunta;
import edu.fiuba.algo3.view.preguntas.FabricaDeVistasPregunta;
import edu.fiuba.algo3.view.preguntas.VistaTipoDePregunta;
import edu.fiuba.algo3.view.preguntas.VistaVerdaderoYFalso;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VistaCambiarJugador extends StackPane {

    FabricaDeVistasPregunta fabrica = new FabricaDeVistasPregunta();
    GridPane grid;

    public VistaCambiarJugador(Kahoot modelo, Jugador jugador, Stage stage){
        this.getChildren().clear();
        this.crearGrid();
        this.agregarBotonSiguienteJugador(stage, modelo, jugador);
        this.getChildren().addAll(grid);
    }

    private void crearGrid(){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
    }

    private void agregarBotonSiguienteJugador(Stage stage, Kahoot modelo, Jugador jugador){
        Button boton = new Button("Siguiente jugador");
        boton.setOnAction(new ReCrearLaPregunta(stage, modelo, jugador));
        grid.add(boton,1,1);
    }
}
