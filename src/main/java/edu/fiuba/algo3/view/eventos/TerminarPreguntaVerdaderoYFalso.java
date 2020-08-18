package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.RespuestaDeJugador;
import edu.fiuba.algo3.view.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TerminarPreguntaVerdaderoYFalso implements EventHandler<ActionEvent> {

    Opcion miOpcion;
    Kahoot miModelo;
    Jugador miJugador;
    Stage miStage;

    public TerminarPreguntaVerdaderoYFalso(Opcion opcion, Kahoot modelo, Jugador jugador, Stage stage){
        miOpcion = opcion;
        miModelo = modelo;
        miJugador= jugador;
        miStage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        var respuestas = new ArrayList<RespuestaDeJugador>();
        if (miOpcion != null)
            respuestas.add(new RespuestaDeJugador(miOpcion));
        miModelo.jugadorResponder(miJugador, respuestas);
        VistaPregunta vistaPregunta = new VistaPregunta();
        vistaPregunta.CambiarPreguntaAOtroJugador(miModelo, miJugador, miStage);
        Scene escena = new Scene(vistaPregunta);
        miStage.setScene(escena);
    }
}
