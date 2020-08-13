package edu.fiuba.algo3.view.preguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.RespuestaDeJugador;
import edu.fiuba.algo3.view.VistaPregunta;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaMultipleChoice extends VistaTipoDePregunta {

    public VistaMultipleChoice(Kahoot modelo, Jugador jugador, Stage stage){
        this.getChildren().clear();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label usuario = new Label(jugador.obtenerNombre());
        grid.add(usuario,1,1);
        Label pregunta = new Label(modelo.obtenerPreguntaActual().obtenerTexto());
        grid.add(pregunta,2,2);
        int i = 1;

        var respuestas = new ArrayList<RespuestaDeJugador>();
        for(Opcion opcion : modelo.obtenerPreguntaActual().obtenerOpciones()){
            Button boton = new Button(opcion.obtenerTexto());
            boton.setOnAction(actionEvent -> {

                respuestas.add(new RespuestaDeJugador(opcion));

            });
            grid.add(boton,i,3);
            i++;
        }
        Button boton2 = new Button("Aceptar");
        boton2.setOnAction(actionEvent -> {
            modelo.jugadorResponder(jugador, respuestas);
            VistaPregunta vistaAux = new VistaPregunta();
            vistaAux.CambiarPreguntaAOtroJugador(modelo, jugador, stage);
            this.getChildren().clear();
            this.getChildren().addAll(vistaAux);
        });
        grid.add(boton2,10,15);
        this.getChildren().addAll(grid);
    }
}
