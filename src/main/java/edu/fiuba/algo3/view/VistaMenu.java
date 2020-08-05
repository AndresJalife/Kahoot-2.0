package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Kahoot;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaMenu extends StackPane {

    private Button jugarBoton;

    public VistaMenu(Kahoot modelo, Stage stage) {
        this.getChildren().clear();
        GridPane grid = new GridPane();
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
        this.getChildren().addAll(grid);
    }


}
