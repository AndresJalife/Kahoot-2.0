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
import javafx.stage.Stage;

import java.util.List;
import java.util.Stack;

public class VistaMultiplicadores extends StackPane {

//    GridPane grid;

    public VistaMultiplicadores(Kahoot modelo, Stage stage) {
        StackPane stack = new StackPane();
        this.obtenerColorDeFondo(stack);
        this.agregarModificadores(modelo, stack, stage);
    }


    private void agregarModificadores(Kahoot modelo, StackPane stack, Stage stage){
        this.getChildren().clear();
        Jugador jugador = modelo.obtenerJugadores().get(0);

        Label titulo = new Label("Elija el modificador para la siguiente ronda:");
        stack.getChildren().addAll(titulo);
        stack.setMargin(titulo, new Insets(-600, 0, 0, 0));

        List<IModificador> modificadores = modelo.obtenerModificadores(jugador);
        int i = -400;

        for (IModificador modificador : modificadores) {
            Button boton = new Button(modificador.obtenerNombre());
            boton.setOnAction(actionEvent -> {
                modelo.utilizarModificador(jugador, modificador);
                this.getChildren().add(new VistaPregunta(modelo, modelo.obtenerJugadores().get(0), stage));
            });
            stack.getChildren().addAll(boton);
            stack.setMargin(boton, new Insets(i, 0, 0, 0));
            i += 200;
        }
        this.getChildren().addAll(stack);
    }

    private void obtenerColorDeFondo(StackPane stack) {
        Color color = Color.rgb(122,62,72);
        stack.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }

}
