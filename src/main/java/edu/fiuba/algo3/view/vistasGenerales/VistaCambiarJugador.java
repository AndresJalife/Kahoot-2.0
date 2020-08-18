package edu.fiuba.algo3.view.vistasGenerales;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.eventos.ReCrearLaPregunta;
import edu.fiuba.algo3.view.vistasPreguntas.FabricaDeVistasPregunta;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VistaCambiarJugador extends StackPane {

    FabricaDeVistasPregunta fabrica = new FabricaDeVistasPregunta();
    GridPane grid;

    public VistaCambiarJugador(Kahoot modelo, Jugador jugador, Stage stage){
        this.getChildren().clear();
        this.crearGrid();
        this.agregarBotonSiguienteJugador(stage, modelo, jugador);
        this.obtenerColorDeFondo();
        this.getStylesheets().add(getClass().getResource("/css/escenaPregunta.css").toExternalForm());
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
        grid.add(boton,42,30);
    }
    private void obtenerColorDeFondo() {
        Color color = Color.rgb(122,62,72);
        grid.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
