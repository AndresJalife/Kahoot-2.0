package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.VistaMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setTitle("Kahoot");
        stage.setScene(escenaInicial);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}