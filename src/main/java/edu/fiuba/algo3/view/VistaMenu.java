package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Kahoot;
import javafx.geometry.Insets;
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

    public VistaMenu(Kahoot modelo, Stage stage) {
        this.crearGrid();
        this.obtenerMenuInicio(modelo, stage, grid);
        this.obtenerIngresarArchivo(modelo, stage, grid);
        this.obtenerColorDeFondo(grid);
        this.getChildren().addAll(grid);
    }

    private void crearGrid(){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
    }

    private void obtenerMenuInicio(Kahoot modelo, Stage stage, GridPane grid){
        this.getChildren().clear();
        grid.setHgap(10);
        grid.setVgap(10);

        jugarBoton = new Button("Jugar");
        Label titulo = new Label("Bienvenido a Cajut");
        titulo.setFont(new Font(50));
        jugarBoton.setOnAction(actionEvent -> {
            Scene escenaPregunta = new Scene(new VistaIngresarUsuarios(modelo, stage));
            stage.setScene(escenaPregunta);
        });
        grid.add(titulo,1,1);
        grid.add(jugarBoton,1,5);
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
        Color color = Color.rgb(202,235,226);
        grid.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
