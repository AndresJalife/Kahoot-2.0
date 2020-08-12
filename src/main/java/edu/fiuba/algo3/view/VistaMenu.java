package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.eventos.PruebaAgregarPreguntas;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaMenu extends StackPane {

    private Button jugarBoton;
    GridPane grid;

    public VistaMenu(Kahoot modelo, Stage stage) {
        this.crearGrid();
        this.obtenerMenuInicio(modelo, stage, grid);
        this.obtenerIngresarArchivo(modelo, stage, grid);
        this.obtenerImagenDeFondo(grid);
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

    private void obtenerIngresarArchivo(Kahoot modelo, Stage stage, GridPane grid){
        Label textoAgregarPreguntas = new Label("Ingrese la direccion donde se encuentran las preguntas");
        grid.add(textoAgregarPreguntas,1,7);
        TextField textoParaAgregarPreguntas = new TextField();
        grid.add(textoParaAgregarPreguntas,1,8);
        Button preguntasBoton = new Button("AgregarPreguntas");
        PruebaAgregarPreguntas pruebaAgregarPreguntas = new PruebaAgregarPreguntas(modelo, textoParaAgregarPreguntas.getText());
        preguntasBoton.setOnAction(pruebaAgregarPreguntas);
        grid.add(preguntasBoton,1,9);
    }

    private void obtenerImagenDeFondo(GridPane grid){
        Image imagen = new Image("file:/src/main/java/view/imagenes/FondoDePruebaVistaMenu.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        grid.setBackground(new Background(imagenDeFondo));
    }
}
