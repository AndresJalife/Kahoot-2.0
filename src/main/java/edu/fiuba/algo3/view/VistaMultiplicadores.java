package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.IModificador;
import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.eventos.TerminarVistaModificadores;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;
import java.util.Stack;

public class VistaMultiplicadores extends StackPane {

//    GridPane grid;

    public VistaMultiplicadores(Kahoot modelo, Stage stage, Jugador jugador) {
        this.getChildren().clear();
        this.getStylesheets().add(getClass().getResource("/css/escenaInicial.css").toExternalForm());

        StackPane stack = new StackPane();
        this.obtenerColorDeFondo(stack);

        this.agregarModificadores(modelo, stack, stage, jugador);
        this.getChildren().addAll(stack);

//        Button botonFinal = new Button("Comenzar el Juego");
//        botonFinal.setOnAction(actionEvent -> {
//            this.getChildren().add(new VistaPregunta(modelo, modelo.obtenerJugadores().get(0), stage));
//        });

//        stack.getChildren().addAll(botonFinal);
//        stack.setMargin(botonFinal, new Insets(200, 0, 0, 0));
//
//        this.getChildren().add(stack);
    }

    private void agregarModificadores(Kahoot modelo, StackPane stack, Stage stage, Jugador jugador){
        Label usuario = new Label(jugador.obtenerNombre());
        usuario.setFont(new Font(40));
        stack.getChildren().addAll(usuario);
        stack.setMargin(usuario, new Insets(-400, 0, 0, 0));

        Label titulo = new Label("Elija el modificador para la siguiente ronda:");
        titulo.setFont(new Font(20));
        stack.getChildren().addAll(titulo);
        stack.setMargin(titulo, new Insets(-300, 0, 0, 0));

        List<IModificador> modificadores = modelo.obtenerModificadores(jugador);
        int i = -100;

        for (IModificador modificador : modificadores) {
            Button boton = new Button(modificador.obtenerNombre());
            boton.setOnAction(actionEvent -> {
                hacer algo;
                
                new TerminarVistaModificadores(modelo, stage, jugador, modificador));
            });
            stack.getChildren().addAll(boton);
            stack.setMargin(boton, new Insets(i, 0, 0, 0));
            i += 200;
        }
        Button botonContinuar = new Button("Continuar");
        botonContinuar.setOnAction(new TerminarVistaModificadores(modelo, stage, jugador, null));
        stack.getChildren().addAll(botonContinuar);
        stack.setMargin(botonContinuar, new Insets(300, 0, 0, 0));
    }

    private void obtenerColorDeFondo(StackPane stack) {
        Color color = Color.rgb(122,62,72);
        stack.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }

}
