package edu.fiuba.algo3.view.vistasPreguntas;

import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.view.eventos.ControladorChoiceBox;
import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.vistasGenerales.VistaPregunta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaGroupChoice extends VistaTipoDePregunta {
    private ObservableList<Integer> listaGrupos;
    private VBox vBoxOpciones;
    private Button botonAceptar;
    private ArrayList<RespuestaDeJugador> respuestas;

    public VistaGroupChoice(Kahoot modelo, Jugador jugador, Stage stage) {
        super(modelo,jugador,stage);
        respuestas = new ArrayList<>();
        vBoxOpciones = new VBox();
        botonAceptar = new Button("Aceptar");

        inicializarOpciones();
        setStackPane();

        botonAceptar.setOnAction(this::mandarRespuestas);
        this.getStylesheets().add(getClass().getResource("/css/orderedYGroup.css").toExternalForm());
    }

    private void setStackPane() {
        getChildren().add(vBoxOpciones);
        vBoxOpciones.setSpacing(15);
        setMargin(vBoxOpciones, new Insets(-300, 0, 0, 0));

        getChildren().add(botonAceptar);
        setMargin(botonAceptar, new Insets(50, 0, 0, 0));

    }

    private void inicializarOpciones() {
        String tipoYModoPregunta="Group Choice : ";
        if(modelo.obtenerPreguntaActual().obtenerModo().getClass() == ModoClasico.class) {
            tipoYModoPregunta += "Clasico";
        }


        Label tipoPregunta = new Label(tipoYModoPregunta);
        tipoPregunta.setFont(new Font(17));

        getChildren().add(tipoPregunta);
        setMargin(tipoPregunta, new Insets(-700, 200, 0, 0));

        Pregunta pregunta = modelo.obtenerPreguntaActual();
        botonAceptar.setAlignment(Pos.CENTER);

        listaGrupos = FXCollections.observableArrayList();

        listaGrupos.add(1);
        listaGrupos.add(2);

        for (Opcion opcion : pregunta.obtenerOpcionesMezcladas()) {
            RespuestaDeJugador nuevaRespuestaDeJugador = new RespuestaDeJugador(opcion);

            ChoiceBox<Integer> nuevaChoiceBox = new ChoiceBox<>(listaGrupos);
            Label nuevaOpcionTexto = new Label(opcion.obtenerTexto());

            nuevaOpcionTexto.setFont(Font.font(18));
            nuevaChoiceBox.setPrefHeight(nuevaOpcionTexto.getPrefHeight());

            HBox nuevaCajaOpcion = new HBox(nuevaOpcionTexto, nuevaChoiceBox);
            nuevaCajaOpcion.setAlignment(Pos.CENTER);
            nuevaCajaOpcion.setSpacing(20);

            nuevaChoiceBox.setOnAction(new ControladorChoiceBox(nuevaRespuestaDeJugador,nuevaChoiceBox));

            nuevaCajaOpcion.setAlignment(Pos.CENTER);
            vBoxOpciones.getChildren().add(nuevaCajaOpcion);
            vBoxOpciones.setAlignment(Pos.CENTER);

            respuestas.add(nuevaRespuestaDeJugador);
        }
    }

    public void mandarRespuestas(ActionEvent event) {
        AudioClip sonidoBoton = new AudioClip(this.getClass().getResource("/sonidos/botonClick.mp3").toExternalForm());
        sonidoBoton.setVolume(100);
        sonidoBoton.play();

        modelo.jugadorResponder(jugador, respuestas);
        VistaPregunta vistaAux = new VistaPregunta();
        vistaAux.CambiarPreguntaAOtroJugador(modelo, jugador, stage);
        stage.setScene(new Scene(vistaAux));
    }

    @Override
    public void forzarContestar() {
        mandarRespuestas(null);
    }
}
