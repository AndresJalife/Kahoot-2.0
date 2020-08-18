package edu.fiuba.algo3.view.preguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.view.VistaPregunta;
import edu.fiuba.algo3.view.eventos.TerminarPreguntaVerdaderoYFalso;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VistaOrderedChoice extends VistaTipoDePregunta {
    private List<Opcion> opciones;
    private SplitPane splitPane ;
    private Label textoPregunta = new Label();
    private Label nombreJugador = new Label();
    private Timeline tiempo;
    private AnchorPane parteSuperior;
    private AnchorPane parteInferior;
    private VBox vBoxParteInferior;
    private VBox vBoxOpciones;
    private Button aceptar;
    private Kahoot modelo;
    private Jugador jugador;
    private Stage stage;
    private ArrayList<RespuestaDeJugador> respuestas;

    public VistaOrderedChoice(Kahoot modelo, Jugador jugador, Stage stage) {
        super();
        opciones = new ArrayList<>();
        opciones = modelo.obtenerPreguntaActual().obtenerOpciones();
        respuestas = new ArrayList<RespuestaDeJugador>();
        this.modelo = modelo;
        this.jugador = jugador;
        this.stage = stage;

        parteSuperior = new AnchorPane();
        parteInferior = new AnchorPane();
        splitPane = new SplitPane(parteSuperior,parteInferior);
        this.inicializarParteSuperior(stage);
        this.inicializarParteInferior(stage);

        this.inicializarSplitPane(stage);
        this.obtenerLabels(stage, jugador, modelo);
        this.crearChoiceBoxes(modelo, jugador, stage);
        this.getChildren().addAll(splitPane);
    }

    private void crearChoiceBoxes(Kahoot modelo, Jugador jugador, Stage stage) {

        Collections.shuffle(opciones);
        List<Integer>posiciones = new ArrayList<>();
        for(int i=0 ;i < opciones.size();i++){
             posiciones.add(i+1);
        }
        List<ChoiceBox> choiceBoxes = new ArrayList<>();
        for(Opcion opcion: opciones){
            choiceBoxes.add(new ChoiceBox(FXCollections.observableArrayList(posiciones)));
        }

        int i=0;
        for(Opcion opcion: opciones){

            ChoiceBox finalChoiceBoxAux;
            finalChoiceBoxAux = choiceBoxes.get(i);
            finalChoiceBoxAux.setPrefWidth(10);
            finalChoiceBoxAux.setPrefHeight(26);

            Label opcionTexto = new Label(opcion.obtenerTexto());
            opcionTexto.setPrefHeight(26);
            opcionTexto.setFont(Font.font(14));

            ChoiceBox finalChoiceBoxAux1 = finalChoiceBoxAux;
            choiceBoxes.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Integer pos = (int) finalChoiceBoxAux1.getValue();
                    if (pos == null) {
                        System.out.println("NULLL POINTER ");
                    } else {
                        RespuestaDeJugador respuesta = new RespuestaDeJugador(opcion);
                        respuestas.add(respuesta);
                        System.out.println(respuesta.obtenerTexto());
                    }
                }
            });
            vBoxOpciones.getChildren().add(opcionTexto);
            vBoxOpciones.getChildren().add(finalChoiceBoxAux1);
            i++;
        }
        aceptar.setOnAction(this::mandarRespuestas);
        vBoxOpciones.getChildren().add(aceptar);
    }


    private void obtenerLabels(Stage stage, Jugador jugador, Kahoot modelo) {
        textoPregunta.setText(modelo.obtenerPreguntaActual().obtenerTexto());
        nombreJugador.setText(jugador.obtenerNombre());

    }

    private void inicializarParteInferior(Stage stage) {
        vBoxParteInferior = new VBox();
        vBoxOpciones = new VBox();
        aceptar = new Button("Aceptar");

        aceptar.setAlignment(Pos.BOTTOM_CENTER);
        aceptar.setPrefSize(40,75);

        vBoxOpciones.setAlignment(Pos.CENTER);
        vBoxOpciones.setPrefHeight(parteInferior.getHeight() -aceptar.getHeight());

        vBoxParteInferior.getChildren().add(vBoxOpciones);
        vBoxParteInferior.getChildren().add(aceptar);

        vBoxParteInferior.setAlignment(Pos.CENTER);
        vBoxParteInferior.setPrefHeight(splitPane.getDividerPositions().length);
        vBoxParteInferior.setPrefWidth(stage.getWidth());

        parteInferior.setMinWidth(0);
        parteInferior.setMinHeight(0);
        parteInferior.setPrefHeight(286);
        parteInferior.setPrefWidth(stage.getWidth());

        parteInferior.getChildren().add(vBoxParteInferior);
    }

    private void inicializarParteSuperior(Stage stage) {
        parteSuperior.setMinHeight(0);
        parteSuperior.setMinWidth(0);
        parteSuperior.setPrefHeight(74);
        parteSuperior.setPrefWidth(stage.getWidth());

        textoPregunta.setAlignment(Pos.CENTER);
        textoPregunta.setContentDisplay(ContentDisplay.CENTER);
        textoPregunta.setLayoutX(237.0);
        textoPregunta.setLayoutY(36);
        textoPregunta.setTextAlignment(TextAlignment.CENTER);

        nombreJugador.setAlignment(Pos.TOP_LEFT);
        nombreJugador.setLayoutX(543);
        nombreJugador.setLayoutY(5);

        parteSuperior.getChildren().add(textoPregunta);
        parteSuperior.getChildren().add(nombreJugador);
    }

    private void inicializarSplitPane(Stage stage) {
        splitPane.setDividerPosition((int) stage.getHeight(),0.4);
        splitPane.setOrientation(Orientation.VERTICAL);
        splitPane.setFocusTraversable(false);
        splitPane.prefHeight(stage.getHeight());
        splitPane.prefWidth(stage.getWidth());
    }

    private void mandarRespuestas(ActionEvent actionEvent) {
        if (respuestas.size() == opciones.size()) {
            modelo.jugadorResponder(jugador, respuestas);
            VistaPregunta vistaPregunta = new VistaPregunta();
            vistaPregunta.CambiarPreguntaAOtroJugador(modelo,jugador,stage);
            Scene escena = new Scene(vistaPregunta);
            stage.setScene(escena);
        }else {
            Alert fallo = new Alert(Alert.AlertType.ERROR);
            fallo.setHeaderText("Falta agregar posiciones= ");
            fallo.showAndWait();
        }
    }

    @Override
    public void forzarContestar() {
        mandarRespuestas(null);
    }
}
