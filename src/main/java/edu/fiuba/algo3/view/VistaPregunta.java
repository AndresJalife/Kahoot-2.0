package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.view.preguntas.VistaVerdaderoYFalso;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VistaPregunta extends StackPane {

    public VistaPregunta(Kahoot modelo) {
        modelo.comenzar();
        for(Jugador jugador : modelo.obtenerJugadores()){
            var vistaTipoPregunta = new VistaVerdaderoYFalso(modelo.obtenerPreguntaActual(), jugador);
            this.getChildren().addAll(vistaTipoPregunta);
        }
    }
}
