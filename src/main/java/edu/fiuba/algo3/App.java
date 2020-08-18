package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.vistasGenerales.VistaMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */


public class App extends Application {
    private Kahoot modelo;
    @Override
    public void start(Stage stage) {
        modelo = new Kahoot();
        cargarPreguntasKahoot();
        var escenaInicial = new Scene(new VistaMenu(modelo, stage));
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

    public void cargarPreguntasKahoot(){
        try {
            modelo.inicializarPreguntas(getClass().getResource("/preguntas.json").toURI());

        }
        catch (Exception e){
            Alert fallo = new Alert(Alert.AlertType.ERROR);
            fallo.setHeaderText(String.format("Archivo de preguntas faltante. \nError: %s", e.toString()));
            fallo.showAndWait();
            Runtime.getRuntime().exit(0);
        }
    }

}