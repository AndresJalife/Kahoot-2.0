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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaVerdaderoYFalso extends VistaTipoDePregunta {

//    GridPane grid;
    StackPane stack;

    public VistaVerdaderoYFalso(Kahoot modelo, Jugador jugador, Stage stage){
        super();
        stack = new StackPane();
        this.getStylesheets().add(getClass().getResource("/css/escenaInicial.css").toExternalForm());
        this.obtenerLabels(jugador, modelo);
        this.obtenerBotonesParaResponder(modelo, jugador, stage);
        this.obtenerColorDeFondo();
        this.getChildren().addAll(stack);
    }


    private void obtenerLabels(Jugador jugador, Kahoot modelo){
        Label usuario = new Label(jugador.obtenerNombre());
        usuario.setFont(Font.font("Arial", FontWeight.BOLD, 35));
        stack.getChildren().add(usuario);
        stack.setMargin(usuario, new Insets(-600, 0, 0, 0));

        Label pregunta = new Label(modelo.obtenerPreguntaActual().obtenerTexto());
        pregunta.setFont(new Font(20));
        stack.getChildren().add(pregunta);
        stack.setMargin(pregunta, new Insets(-500, 0, 0, 0));
    }

    private void obtenerBotonesParaResponder(Kahoot modelo, Jugador jugador, Stage stage){
        int i = -400;
        for(Opcion opcion : modelo.obtenerPreguntaActual().obtenerOpciones()){
            Button boton = new Button(opcion.obtenerTexto());
            boton.setOnAction(new TerminarPreguntaVerdaderoYFalso(opcion,modelo,jugador,stage));
            stack.getChildren().add(boton);
            stack.setMargin(boton, new Insets(-200, 0, 0, i));
            i += 800;
        }
    }

    private void obtenerColorDeFondo() {
        Color color = Color.rgb(122,62,72);
        stack.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
