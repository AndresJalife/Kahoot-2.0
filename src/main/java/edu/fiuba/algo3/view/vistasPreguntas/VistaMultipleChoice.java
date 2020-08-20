package edu.fiuba.algo3.view.vistasPreguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.RespuestaDeJugador;
import edu.fiuba.algo3.view.AuxiliarCheckBox;
import edu.fiuba.algo3.view.vistasGenerales.VistaPregunta;
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

    private Button botonAceptar;
    private List<AuxiliarCheckBox> cajas;

    public VistaMultipleChoice(Kahoot modelo, Jugador jugador, Stage stage) {
        super(modelo,jugador,stage);
        botonAceptar = new Button("Aceptar");
        cajas = new ArrayList<>();

        inicializarOpciones();
        setStackPane();

        botonAceptar.setOnAction(this::mandarRespuestas);

        this.getStylesheets().add(getClass().getResource("/css/escenaGeneral.css").toExternalForm());
        botonAceptar.setOnAction(this::mandarRespuestas);

        this.getStylesheets().add(getClass().getResource("/css/escenaGeneral.css").toExternalForm());
    }

    private void inicializarOpciones() {

        int i = -600;
        for(Opcion opcion : modelo.obtenerPreguntaActual().obtenerOpciones()){
            CheckBox boton = new CheckBox(opcion.obtenerTexto());
            cajas.add(new AuxiliarCheckBox(boton, opcion));
            boton.setTextFill(Color.rgb(238, 205, 134));

            getChildren().add(boton);
            setMargin(boton, new Insets(-200, 0, 0, i));

            i += 600;
        }
    }


    private void setStackPane() {
        getChildren().add(botonAceptar);
        setMargin(botonAceptar, new Insets(50, 0, 0, 0));

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
