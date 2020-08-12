package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.preguntas.VistaVerdaderoYFalso;
import edu.fiuba.algo3.view.VistaRespuestas;
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
        this.getChildren().clear();
        if(modelo.todosContestaron()){
            VistaTerminar vistaRespuesta = new VistaTerminar(modelo);
            this.getChildren().addAll(vistaRespuesta);
        }
        else{
            Jugador siguiente = jugador;
            for(Jugador jugadoraux : modelo.obtenerJugadores()){
                if(jugadoraux != jugador)
                    siguiente = jugadoraux;
            }
            VistaCambiarJugador vistaCambiarJugador = new VistaCambiarJugador(modelo, siguiente);
            this.getChildren().addAll(vistaCambiarJugador);
        }
    }
}
