package edu.fiuba.algo3.view.vistasGenerales;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.eventos.PonerVistaIngresarUsuarios;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaMenu extends StackPane {

    private Button jugarBoton;
    StackPane stack;

    public VistaMenu(Kahoot modelo, Stage stage) {
        this.obtenerMenuInicio(modelo, stage);
        this.obtenerColorDeFondo();
        this.getChildren().addAll(stack);
    }

    private void obtenerMenuInicio(Kahoot modelo, Stage stage){
        this.getChildren().clear();
        stack = new StackPane();
        jugarBoton = new Button("Iniciar");
        jugarBoton.setOnAction(new PonerVistaIngresarUsuarios(modelo, stage));

        Button ayudaBoton = new Button("?");
        ayudaBoton.setOnAction(actionEvent -> {
            Label ayuda = new Label( "Bienvenidos! Este es un juego de pregunta - respuesta multijugador.\n" +
                                        "Al comienzo de cada pregunta cada jugador va a poder elegir una  \n" +
                                        "exclusividad (en caso de que la pregunta no tenga penalidad) o un \n" +
                                        "multiplicador x2 o x3 en caso contrario. Buena suerte!" );
            stack.getChildren().add(ayuda);
            stack.setMargin(ayuda, new Insets(200, 0, 0, 0));
        });

        Label titulo = new Label("Bienvenido a Cajoot");
        titulo.setFont(new Font(50));


        stack.getChildren().addAll(titulo, jugarBoton, ayudaBoton);
        stack.setMargin(titulo, new Insets(-200, 0, 0, 0));
        stack.setMargin(ayudaBoton, new Insets(600, -800, 0, 0));
    }

    private void obtenerColorDeFondo() {
        Color color = Color.rgb(122,62,72);
        stack.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
