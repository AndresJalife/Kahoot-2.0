package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Kahoot;
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
    GridPane grid;
    StackPane stack;

    public VistaMenu(Kahoot modelo, Stage stage) {
        this.obtenerMenuInicio(modelo, stage);
        this.obtenerIngresarArchivo(modelo, stage, grid);
        this.obtenerColorDeFondo(grid);
        this.getChildren().addAll(stack);
    }



    private void obtenerMenuInicio(Kahoot modelo, Stage stage){
        this.getChildren().clear();

        jugarBoton = new Button("Jugar");
        Label titulo = new Label("Bienvenido a Cajut");
        titulo.setFont(new Font(50));
        jugarBoton.setOnAction(actionEvent -> {
            Scene escenaPregunta = new Scene(new VistaIngresarUsuarios(modelo, stage));
            stage.setScene(escenaPregunta);
        });
        stack = new StackPane();
        stack.getChildren().addAll(titulo, jugarBoton);
        stack.setMargin(titulo, new Insets(-200, -10, 0, 30));


    }

    private void obtenerIngresarArchivo(Kahoot modelo, Stage stage, GridPane grid) {
        try {
            modelo.inicializarPreguntas(getClass().getResource("/semiPreguntas.json").toURI());

        }
        catch (Exception e){
            Alert fallo = new Alert(Alert.AlertType.ERROR);
            fallo.setHeaderText(String.format("Archivo de preguntas faltante. \nError: %s", e.toString()));
            fallo.showAndWait();
            Runtime.getRuntime().exit(0);
        }
    }

    private void obtenerColorDeFondo(GridPane grid) {
        Color color = Color.rgb(122,62,72);
        stack.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
