package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.preguntas.RespuestaDeJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;

public class ControladorSeleccionGrupos implements EventHandler<ActionEvent> {
    private final ChoiceBox<Integer> seleccionadorGrupo;
    private final RespuestaDeJugador respuestaDeJugador;
    public ControladorSeleccionGrupos(RespuestaDeJugador respuestaDeJugador,ChoiceBox choiceBox) {
        this.respuestaDeJugador = respuestaDeJugador;
        this.seleccionadorGrupo = choiceBox;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        respuestaDeJugador.cambiarGrupo(seleccionadorGrupo.getValue());
    }
}