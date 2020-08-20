package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.preguntas.RespuestaDeJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.media.AudioClip;

import java.util.Objects;

public class ControladorChoiceBox implements EventHandler<ActionEvent> {
    private final ChoiceBox<Integer> seleccionadorGrupo;
    private final RespuestaDeJugador respuestaDeJugador;

    public ControladorChoiceBox(RespuestaDeJugador respuestaDeJugador, ChoiceBox<Integer> choiceBox) {
        this.respuestaDeJugador = respuestaDeJugador;
        this.seleccionadorGrupo = choiceBox;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        AudioClip sonidoBoton = new AudioClip(this.getClass().getResource("/sonidos/botonClick.mp3").toExternalForm());
        sonidoBoton.setVolume(100);
        sonidoBoton.play();
        Integer valor = seleccionadorGrupo.getValue();
        respuestaDeJugador.setGrupoElegido(Objects.requireNonNullElse(valor, 0));
    }
}