package edu.fiuba.algo3.view.preguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.RespuestaDeJugador;
import edu.fiuba.algo3.view.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VistaMultipleChoice extends VistaTipoDePregunta {

    private Kahoot modelo;
    private Jugador jugador;
    private Stage stage;
    private List<AuxiliarCheckBox> cajas;

    public VistaMultipleChoice(Kahoot modelo, Jugador jugador, Stage stage) {
        this.modelo = modelo;
        this.jugador = jugador;
        this.stage = stage;

        this.getChildren().clear();
        this.getStylesheets().add(getClass().getResource("/css/escenaInicial.css").toExternalForm());
        StackPane stack = new StackPane();


        Label usuario = new Label(jugador.obtenerNombre());
        usuario.setFont(Font.font("Arial", FontWeight.BOLD, 35));

        stack.getChildren().add(usuario);
        stack.setMargin(usuario, new Insets(-600, 0, 0, 0));

        Label pregunta = new Label(modelo.obtenerPreguntaActual().obtenerTexto());
        pregunta.setFont(new Font(20));

        stack.getChildren().add(pregunta);
        stack.setMargin(pregunta, new Insets(-500, 0, 0, 0));


        int i = -600;
        this.cajas = new ArrayList<>();
        for(Opcion opcion : modelo.obtenerPreguntaActual().obtenerOpciones()){
            CheckBox boton = new CheckBox(opcion.obtenerTexto());
            cajas.add(new AuxiliarCheckBox(boton, opcion));

            stack.getChildren().add(boton);
            stack.setMargin(boton, new Insets(-200, 0, 0, i));

            i += 600;
        }
        Button boton2 = new Button("Aceptar");
        boton2.setOnAction(this::mandarRespuestas);

        stack.getChildren().add(boton2);
        stack.setMargin(boton2, new Insets(0, 0, 0, 0));

        this.getStylesheets().add(getClass().getResource("/css/escenaPregunta.css").toExternalForm());
        this.obtenerColorDeFondo(stack);
        this.getChildren().addAll(stack);
    }

    private void obtenerColorDeFondo(StackPane stack) {
        Color color = Color.rgb(122,62,72);
        stack.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }

    private void mandarRespuestas(ActionEvent event) {
        var respuestas = new ArrayList<RespuestaDeJugador>();
        for(AuxiliarCheckBox aux : cajas){
            if(aux.obtenerCheckBox().isSelected())
                respuestas.add(new RespuestaDeJugador(aux.obtenerOpcion()));
        }
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
