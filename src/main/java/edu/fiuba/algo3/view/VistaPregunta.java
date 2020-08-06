package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.view.preguntas.VistaVerdaderoYFalso;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;

public class VistaPregunta extends StackPane {

    public VistaPregunta(){}

    public VistaPregunta(Kahoot modelo , Jugador jugador) {
        modelo.comenzar();
        VistaVerdaderoYFalso vistaTipoPregunta = new VistaVerdaderoYFalso(modelo, jugador);
        this.getChildren().addAll(vistaTipoPregunta);
    }

    public void CambiarPreguntaAOtroJugador(Kahoot modelo, Jugador jugador){
        if(modelo.todosContestaron()){

        }
        else{
            Jugador siguiente = jugador;
            for(Jugador jugadoraux : modelo.obtenerJugadores()){
                if(jugadoraux != jugador)
                    siguiente = jugadoraux;
            }
            VistaVerdaderoYFalso vistaTipoPregunta = new VistaVerdaderoYFalso(modelo, siguiente);
            this.getChildren().addAll(vistaTipoPregunta);
        }
    }
}
