package edu.fiuba.algo3.view.preguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.RespuestaDeJugador;
import edu.fiuba.algo3.view.VistaPregunta;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class VistaMultipleChoice extends VistaTipoDePregunta {

    public VistaMultipleChoice(Kahoot modelo, Jugador jugador){
        this.getChildren().clear();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label usuario = new Label(jugador.obtenerNombre());
        grid.add(usuario,1,1);
        Label pregunta = new Label(modelo.obtenerPreguntaActual().obtenerTexto());
        grid.add(pregunta,2,2);
        int i = 1;

        for(Opcion opcion : modelo.obtenerPreguntaActual().obtenerOpciones()){
            Button boton = new Button(opcion.obtenerTexto());
            Button boton2 = new Button("Aceptar");
            var respuestas = new ArrayList<RespuestaDeJugador>();
            boton2.setOnAction(actionEvent -> {
                modelo.jugadorResponder(jugador, respuestas);
                VistaPregunta vistaAux = new VistaPregunta();
                vistaAux.CambiarPreguntaAOtroJugador(modelo, jugador);
                this.getChildren().clear();
                this.getChildren().addAll(vistaAux);
            });
            boton.setOnAction(actionEvent -> {

                respuestas.add(new RespuestaDeJugador(opcion));

            });
            grid.add(boton,i,3);
            grid.add(boton2,10,15);
            i++;
        }


        this.getChildren().addAll(grid);
    }
}
