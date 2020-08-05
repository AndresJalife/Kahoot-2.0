package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Kahoot;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class VistaMenu extends StackPane {

    private Label tituloTexto;
    private Button jugarBoton;

    public VistaMenu(Kahoot modelo) {
        tituloTexto = new Label("Kahoot");
        jugarBoton = new Button("Jugar");
        this.getChildren().addAll(tituloTexto, jugarBoton);
    }


}
