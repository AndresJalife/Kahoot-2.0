package edu.fiuba.algo3.view.vistasPreguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.ModoClasico;
import edu.fiuba.algo3.modelo.preguntas.ModoConPenalidad;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.RespuestaDeJugador;
import edu.fiuba.algo3.view.AuxiliarCheckBox;
import edu.fiuba.algo3.view.vistasGenerales.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
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

        int i = -300;
        int cant = 0;
        for(Opcion opcion : modelo.obtenerPreguntaActual().obtenerOpciones()){
            if(cant == 3) i = -300;
            CheckBox boton = new CheckBox(opcion.obtenerTexto());
            cajas.add(new AuxiliarCheckBox(boton, opcion));
            boton.setTextFill(Color.rgb(238, 205, 134));
            boton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    AudioClip sonidoBoton = new AudioClip(this.getClass().getResource("/sonidos/botonClick.mp3").toExternalForm());
                    sonidoBoton.setVolume(100);
                    sonidoBoton.play();
                }
            });
            getChildren().add(boton);
            if(cant <3) setMargin(boton, new Insets(-200, 0, 0, i));

            else setMargin(boton, new Insets(-100, 0, 0, i));
            i += 300;
            cant++;
        }
    }


    private void setStackPane() {
        String tipoYModoPregunta="Multiple Choice : ";
        if(modelo.obtenerPreguntaActual().obtenerModo().getClass() == ModoClasico.class){
            tipoYModoPregunta += "Clasico";
        }else if(modelo.obtenerPreguntaActual().obtenerModo().getClass() == ModoConPenalidad.class){
            tipoYModoPregunta += "Con Penalidad";
        }else tipoYModoPregunta += "Con Puntaje Parcial";


        Label tipoPregunta = new Label(tipoYModoPregunta);
        tipoPregunta.setFont(new Font(17));

        getChildren().add(tipoPregunta);
        setMargin(tipoPregunta, new Insets(-700, 200, 0, 0));

        getChildren().add(botonAceptar);
        setMargin(botonAceptar, new Insets(50, 0, 0, 0));

    }


    private void mandarRespuestas(ActionEvent event) {
        AudioClip sonidoBoton = new AudioClip(this.getClass().getResource("/sonidos/botonClick.mp3").toExternalForm());
        sonidoBoton.setVolume(100);
        sonidoBoton.play();

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
