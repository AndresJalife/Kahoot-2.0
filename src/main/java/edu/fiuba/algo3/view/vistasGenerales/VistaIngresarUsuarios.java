package edu.fiuba.algo3.view.vistasGenerales;

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

import java.util.Stack;

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
        usuarioUno.setTextFill(Color.rgb(238, 205, 134));
        usuarioUno.setFont(new Font(15));
        grid.add(usuarioUno,25,25);
        TextField textoParaUsuarioUno = new TextField("Jugador 1");
        textoParaUsuarioUno.setOnMouseClicked(mouseEvent -> textoParaUsuarioUno.setText(""));
        grid.add(textoParaUsuarioUno,26,25);
        Label usuarioDos = new Label("Ingrese el nombre del jugador 2");
        usuarioDos.setFont(new Font(15));
        usuarioDos.setTextFill(Color.rgb(238, 205, 134));
        grid.add(usuarioDos,25,26);
        TextField textoParaUsuarioDos = new TextField("Jugador 2");
        textoParaUsuarioDos.setOnMouseClicked(mouseEvent -> textoParaUsuarioDos.setText(""));
        grid.add(textoParaUsuarioDos,26,26);
        Button jugarBoton = new Button("Jugar");
        jugarBoton.setOnAction(new EmpezarJuego(textoParaUsuarioUno, textoParaUsuarioDos, modelo, stage));
        grid.add(jugarBoton,26,27);
    }

    private void obtenerColorDeFondo(GridPane grid) {
        Color color = Color.rgb(122,62,72);
        grid.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
