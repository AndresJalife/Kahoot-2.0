package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.view.preguntas.VistaVerdaderoYFalso;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class VistaPregunta extends StackPane {

    public VistaPregunta(Pregunta pregunta) {
        var titulo = new Label("Pregunta");
        var vistaTipoPregunta = new VistaVerdaderoYFalso();
        this.getChildren().addAll(titulo, vistaTipoPregunta);
    }
}
