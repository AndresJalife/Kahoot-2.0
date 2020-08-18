package edu.fiuba.algo3.view.vistasPreguntas;

import edu.fiuba.algo3.controller.ControladorSeleccionGrupos;
import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.view.VistaPregunta;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaOrderedChoice extends VistaTipoDePregunta {
    private ObservableList<Integer> listaPosiciones;
    private VBox vBoxOpciones;
    private Label nombreJugador;
    private Label preguntaTexto;
    private Button botonAceptar;
    private ArrayList<RespuestaDeJugador> respuestas;

    public VistaOrderedChoice(Kahoot modelo, Jugador jugador, Stage stage) {
        super();
        this.getChildren().clear();
        inicializarTextos(modelo, jugador);

        setStackPane();
        this.setColorFondo();
        botonAceptar.setOnAction(actionEvent -> {
            modelo.jugadorResponder(jugador, respuestas);
            VistaPregunta vistaAux = new VistaPregunta();
            vistaAux.CambiarPreguntaAOtroJugador(modelo, jugador, stage);
            this.getChildren().clear();
            this.getChildren().addAll(vistaAux);
        });
        this.getStylesheets().add(getClass().getResource("/css/escenaPregunta.css").toExternalForm());
    }
    private void setStackPane () {
        this.setAlignment(Pos.CENTER);

        this.getChildren().add(nombreJugador);
        this.setMargin(nombreJugador, new Insets(-600, 0, 0, 0));

        this.getChildren().add(preguntaTexto);
        this.setMargin(preguntaTexto, new Insets(-500, 0, 0, 0));

        this.getChildren().add(vBoxOpciones);
        this.setMargin(vBoxOpciones, new Insets(-400, 0, 0, 0));
        this.getChildren().add(botonAceptar);
        this.setMargin(botonAceptar, new Insets(0, 0, 0, 0));

    }

    private void inicializarTextos (Kahoot modelo, Jugador jugador){
        Pregunta pregunta = modelo.obtenerPreguntaActual();

        nombreJugador = new Label(jugador.obtenerNombre());
        nombreJugador.setFont(Font.font("Arial", FontWeight.BOLD, 35));
        preguntaTexto = new Label(pregunta.obtenerTexto());
        preguntaTexto.setFont(new Font(20));

        botonAceptar = new Button("Aceptar");
        botonAceptar.setAlignment(Pos.CENTER);

        listaPosiciones = FXCollections.observableArrayList();

        for (int i = 0; i < pregunta.obtenerOpcionesMezcladas().size() ; i++) {
            listaPosiciones.add(i+1);
        }

        respuestas = new ArrayList<>();

        vBoxOpciones = new VBox();
        for (Opcion opcion : pregunta.obtenerOpcionesMezcladas()) {
            RespuestaDeJugador nuevaRespuestaDeJugador = new RespuestaDeJugador(opcion);

            ChoiceBox<Integer> nuevaChoiceBox = new ChoiceBox<>(listaPosiciones);
            Label nuevaOpcionTexto = new Label(opcion.obtenerTexto());

            nuevaOpcionTexto.setFont(Font.font(18));
            nuevaChoiceBox.setPrefHeight(nuevaOpcionTexto.getPrefHeight());

            HBox nuevaCajaOpcion = new HBox(nuevaOpcionTexto, nuevaChoiceBox);
            nuevaCajaOpcion.setAlignment(Pos.CENTER);

            nuevaChoiceBox.setOnAction(new ControladorSeleccionGrupos(nuevaRespuestaDeJugador, nuevaChoiceBox));

            HBox cajaOpcionYChoiceBox = new HBox(nuevaOpcionTexto, nuevaChoiceBox);
            cajaOpcionYChoiceBox.setAlignment(Pos.CENTER);
            vBoxOpciones.getChildren().add(cajaOpcionYChoiceBox);
            vBoxOpciones.setAlignment(Pos.CENTER);

            respuestas.add(nuevaRespuestaDeJugador);
        }
    }

    private void setColorFondo () {
        Color color = Color.rgb(122, 62, 72);
        this.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
