package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.IModificador;
import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;
import java.util.Stack;

public class VistaMultiplicadores extends StackPane {


    public VistaMultiplicadores(Kahoot modelo, Stage stage, Jugador jugador) {
        StackPane stack = new StackPane();
        this.obtenerColorDeFondo(stack);
        this.getStylesheets().add(getClass().getResource("/css/escenaInicial.css").toExternalForm());
        this.agregarModificadores(modelo, stack, stage, jugador);
    }


    private void agregarModificadores(Kahoot modelo, StackPane stack, Stage stage, Jugador jugador){
        this.getChildren().clear();

        Label nombreJugador = new Label(jugador.obtenerNombre());
        nombreJugador.setFont(Font.font("Arial", FontWeight.BOLD, 35));
        stack.getChildren().addAll(nombreJugador);
        setMargin(nombreJugador, new Insets(-600, 0, 0, 0));
        Label titulo = new Label("Elija el modificador para la siguiente ronda:");
        titulo.setFont(new Font(20));
        stack.getChildren().addAll(titulo);
        stack.setMargin(titulo, new Insets(-500, 0, 0, 0));

        List<IModificador> modificadores = modelo.obtenerModificadores(jugador);
        int i = -400;

        for (IModificador modificador : modificadores) {
            Button boton = new Button(modificador.obtenerNombre());
            boton.setOnAction(actionEvent -> {
                modelo.utilizarModificador(jugador, modificador);
                if(jugador == modelo.obtenerPrimerJugador())
                    this.getChildren().add(new VistaMultiplicadores(modelo, stage, modelo.obtenerJugadores().get(1)));
                else
                    this.getChildren().add(new VistaPregunta(modelo, modelo.obtenerJugadores().get(0), stage));
            });
            stack.getChildren().addAll(boton);
            stack.setMargin(boton, new Insets(i, 0, 0, 0));
            i += 200;
        }

        Button boton = new Button("Pasar");
        boton.setOnAction(actionEvent -> {
            if(jugador == modelo.obtenerPrimerJugador())
                this.getChildren().add(new VistaMultiplicadores(modelo, stage, modelo.obtenerJugadores().get(1)));
            else
                this.getChildren().add(new VistaPregunta(modelo, modelo.obtenerJugadores().get(0), stage));
        });
        stack.getChildren().addAll(boton);
        stack.setMargin(boton, new Insets(i, 0, 0, 0));
        this.getChildren().addAll(stack);
    }

    private void obtenerColorDeFondo(StackPane stack) {
        Color color = Color.rgb(122,62,72);
        stack.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }

}
