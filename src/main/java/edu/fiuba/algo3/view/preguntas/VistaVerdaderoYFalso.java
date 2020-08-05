package edu.fiuba.algo3.view.preguntas;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VistaVerdaderoYFalso extends StackPane {

    public VistaVerdaderoYFalso(Pregunta preguntaActual){
        this.getChildren().clear();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label pregunta = new Label(preguntaActual.obtenerTexto());
        grid.add(pregunta,1,1);
        int i = 2;
        for(Opcion opcion : preguntaActual.obtenerOpciones()){
            Button boton = new Button(opcion.obtenerTexto());
            grid.add(boton,2,i);
            i++;
        }
        this.getChildren().addAll(grid);
    }
}
