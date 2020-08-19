package edu.fiuba.algo3.view.vistasPreguntas;

import edu.fiuba.algo3.controller.ControladorChoiceBox;
import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.view.vistasGenerales.VistaPregunta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
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
    private Kahoot modelo;
    private Jugador jugador;
    private Stage stage;
    private ArrayList<RespuestaDeJugador> respuestas;

    public VistaOrderedChoice(Kahoot modelo, Jugador jugador, Stage stage) {
        super();
        this.getChildren().clear();
        this.modelo = modelo;
        this.jugador = jugador;
        this.stage = stage;
        inicializarTextos(modelo, jugador);

        setStackPane();
        this.setColorFondo();
        botonAceptar.setOnAction(this::mandarRespuestas);
        this.getStylesheets().add(getClass().getResource("/css/orderedYGroup.css").toExternalForm());
    }
    private void setStackPane () {
        this.setAlignment(Pos.CENTER);

        this.getChildren().add(nombreJugador);
        setMargin(nombreJugador, new Insets(-600, 0, 0, 0));

        this.getChildren().add(preguntaTexto);
        setMargin(preguntaTexto, new Insets(-500, 0, 0, 0));

        this.getChildren().add(vBoxOpciones);
        vBoxOpciones.setSpacing(15);
        setMargin(vBoxOpciones, new Insets(-300, 0, 0, 0));

        this.getChildren().add(botonAceptar);
        setMargin(botonAceptar, new Insets(0, 0, 0, 0));

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
            nuevaCajaOpcion.setSpacing(10);
            nuevaChoiceBox.setOnAction(new ControladorChoiceBox(nuevaRespuestaDeJugador, nuevaChoiceBox));

            HBox cajaOpcionYChoiceBox = new HBox(nuevaOpcionTexto, nuevaChoiceBox);
            cajaOpcionYChoiceBox.setAlignment(Pos.CENTER);
            vBoxOpciones.getChildren().add(cajaOpcionYChoiceBox);
            vBoxOpciones.setAlignment(Pos.CENTER);
            vBoxOpciones.setSpacing(20);
            respuestas.add(nuevaRespuestaDeJugador);
        }
    }

    private void setColorFondo () {
        Color color = Color.rgb(122, 62, 72);
        this.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }

    private void mandarRespuestas(ActionEvent actionEvent) {
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
