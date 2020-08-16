package edu.fiuba.algo3.view.preguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.RespuestaDeJugador;
import edu.fiuba.algo3.view.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
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

    public VistaMultipleChoice(Kahoot modelo, Jugador jugador, Stage stage){
        this.getChildren().clear();
//        GridPane grid = new GridPane();
        StackPane stack = new StackPane();
//        grid.setHgap(10);
//        grid.setVgap(10);

        Label usuario = new Label(jugador.obtenerNombre());
        usuario.setFont(Font.font("Arial", FontWeight.BOLD, 35));
//        grid.add(usuario,35,3);
        stack.getChildren().add(usuario);
        stack.setMargin(usuario, new Insets(-600, 0, 0, 0));

        Label pregunta = new Label(modelo.obtenerPreguntaActual().obtenerTexto());
        pregunta.setFont(new Font(20));
//        grid.add(pregunta,35,5);
        stack.getChildren().add(pregunta);
        stack.setMargin(pregunta, new Insets(-500, 0, 0, 0));

//        int i = 34;
        int i = -600;
        List<AuxiliarCheckBox> cajas = new ArrayList<>();
        for(Opcion opcion : modelo.obtenerPreguntaActual().obtenerOpciones()){
            CheckBox boton = new CheckBox(opcion.obtenerTexto());
            cajas.add(new AuxiliarCheckBox(boton, opcion));
//            grid.add(boton,i,11);
            stack.getChildren().add(boton);
            stack.setMargin(boton, new Insets(-200, 0, 0, i));
//            i++;
            i += 600;
        }
        Button boton2 = new Button("Aceptar");
        var respuestas = new ArrayList<RespuestaDeJugador>();
        boton2.setOnAction(actionEvent -> {
            for(AuxiliarCheckBox aux : cajas){
                if(aux.obtenerCheckBox().isSelected())
                    respuestas.add(new RespuestaDeJugador(aux.obtenerOpcion()));
            }
            modelo.jugadorResponder(jugador, respuestas);
            VistaPregunta vistaAux = new VistaPregunta();
            vistaAux.CambiarPreguntaAOtroJugador(modelo, jugador, stage);
            this.getChildren().clear();
            this.getChildren().addAll(vistaAux);
        });
//        grid.add(boton2,35,15);
        stack.getChildren().add(boton2);
        stack.setMargin(boton2, new Insets(0, 0, 0, 0));

        this.getStylesheets().add(getClass().getResource("/css/escenaPregunta.css").toExternalForm());
        this.obtenerColorDeFondo(stack);
        this.getChildren().addAll(stack);
    }
    private void obtenerColorDeFondo(StackPane grid) {
        Color color = Color.rgb(122,62,72);
        grid.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
