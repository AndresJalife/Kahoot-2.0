package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.eventos.EmpezarJuego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaIngresarUsuarios extends StackPane {

    GridPane grid;

    public VistaIngresarUsuarios(Kahoot modelo, Stage stage){
        this.getChildren().clear();
        this.crearGrid();
        this.obtenerIngresarUsuarios(grid, modelo, stage);
        this.obtenerColorDeFondo(grid);
        this.getChildren().addAll(grid);
    }

    private void crearGrid(){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
    }

    private void obtenerIngresarUsuarios(GridPane grid, Kahoot modelo, Stage stage){
        Label usuarioUno = new Label("Ingrese el nombre del jugador 1");
        usuarioUno.setTextFill(Color.WHITE);
        grid.add(usuarioUno,3,1);
        TextField textoParaUsuarioUno = new TextField();
        grid.add(textoParaUsuarioUno,4,1);
        Label usuarioDos = new Label("Ingrese el nombre del jugador 2");
        usuarioDos.setTextFill(Color.WHITE);
        grid.add(usuarioDos,3,2);
        TextField textoParaUsuarioDos = new TextField();
        grid.add(textoParaUsuarioDos,4,2);
        Button jugarBoton = new Button("Jugar");
        jugarBoton.setOnAction(new EmpezarJuego(textoParaUsuarioUno, textoParaUsuarioDos, modelo, stage));
        grid.add(jugarBoton,4,3);
    }

    private void obtenerColorDeFondo(GridPane grid) {
        Color color = Color.rgb(19,94,75);
        grid.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
