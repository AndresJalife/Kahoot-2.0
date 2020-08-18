package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.preguntas.RespuestaDeJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;

public class ControladorSeleccionGrupos implements EventHandler<ActionEvent> {
    private final ChoiceBox<Integer> seleccionadorGrupo;
    private final RespuestaDeJugador respuestaDeJugador;

    public ControladorSeleccionGrupos(RespuestaDeJugador respuestaDeJugador, ChoiceBox<Integer> choiceBox) {
        this.respuestaDeJugador = respuestaDeJugador;
        this.seleccionadorGrupo = choiceBox;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Integer valor = seleccionadorGrupo.getValue();
        if (valor == null) {
            respuestaDeJugador.setGrupoElegido(0);
        } else {
            respuestaDeJugador.setGrupoElegido(valor.intValue());
            System.out.println("El jugador respondio " + valor);
        }
    }
}