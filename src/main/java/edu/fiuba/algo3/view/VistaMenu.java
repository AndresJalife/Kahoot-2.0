package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.preguntas.VistaVerdaderoYFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VistaMenu extends StackPane {

    private Label tituloTexto;
    private Button jugarBoton;

    public VistaMenu(Kahoot modelo, Stage stage) {
        tituloTexto = new Label("Kahoot");
        jugarBoton = new Button("Jugar");
        jugarBoton.setOnAction(new EventHandler<>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                Scene escenaPregunta = new Scene(new VistaIngresarUsuarios(modelo, stage));
                stage.setScene(escenaPregunta);
            }
        });
        this.getChildren().addAll(tituloTexto, jugarBoton);
    }


}
