package edu.fiuba.algo3.view.preguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.RespuestaDeJugador;
import edu.fiuba.algo3.view.VistaPregunta;
import edu.fiuba.algo3.view.eventos.TerminarPreguntaVerdaderoYFalso;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaVerdaderoYFalso extends VistaTipoDePregunta {

    GridPane grid;

    public VistaVerdaderoYFalso(Kahoot modelo, Jugador jugador, Stage stage){
        super();
        this.crearGrid();
        this.obtenerLabels(grid, jugador, modelo);
        this.obtenerBotonesParaResponder(grid, modelo, jugador, stage);
        this.obtenerColorDeFondo();
        this.getStylesheets().add(getClass().getResource("/css/botonesVF.css").toExternalForm());
        this.getChildren().addAll(grid);
    }

    private void crearGrid(){
        this.getChildren().clear();
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
    }

    private void obtenerLabels(GridPane grid, Jugador jugador, Kahoot modelo){
        Label usuario = new Label(jugador.obtenerNombre());
        grid.add(usuario,1,1);
        Label pregunta = new Label(modelo.obtenerPreguntaActual().obtenerTexto());
        grid.add(pregunta,2,2);
    }

    private void obtenerBotonesParaResponder(GridPane grid, Kahoot modelo, Jugador jugador, Stage stage){
        int i = 2;
        for(Opcion opcion : modelo.obtenerPreguntaActual().obtenerOpciones()){
            Button boton = new Button(opcion.obtenerTexto());
            boton.setOnAction(new TerminarPreguntaVerdaderoYFalso(opcion,modelo,jugador,stage));
            grid.add(boton,i,3);
            i++;
        }
    }

    private void obtenerColorDeFondo() {
        Color color = Color.rgb(122,62,72);
        grid.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
