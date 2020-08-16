package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.VistaMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */


public class App extends Application {

    @Override
    public void start(Stage stage) {
        var modelo = new Kahoot();
        var escenaInicial = new Scene(new VistaMenu(modelo, stage));
//        escenaInicial.getStylesheets().add(getClass().getResource("/css/escenaInicial2.css").toString());
        escenaInicial.getStylesheets().add(getClass().getResource("/css/escenaInicial.css").toExternalForm());
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setTitle("Cajoot");
        stage.setScene(escenaInicial);
        Image imagen = new Image(getClass().getResource("/imagenes/icon.jpg").toString());
        stage.getIcons().add(imagen);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}