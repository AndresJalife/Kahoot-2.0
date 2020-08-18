package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.preguntas.FabricaDeVistasPregunta;
import edu.fiuba.algo3.view.preguntas.VistaTipoDePregunta;
import edu.fiuba.algo3.view.preguntas.VistaVerdaderoYFalso;
import edu.fiuba.algo3.view.VistaRespuestas;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class VistaPregunta extends StackPane {

    private final FabricaDeVistasPregunta fabrica;
    private Label contador;

    public VistaPregunta() {
        fabrica = new FabricaDeVistasPregunta();
    }

    public VistaPregunta(Kahoot modelo , Jugador jugador, Stage stage) {
        this();

        var vistaTipoPregunta = fabrica.crearVistaTipoDePregunta(modelo, jugador, stage);
        var contador = new Label();
        contador.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        //setMargin(contador, new Insets(-200, -100, 0, 0));
        contador.setTranslateX(-400);
        contador.setTranslateY(-350);

        var alCambiar = (Consumer<Integer>) (segundos) -> {
            Platform.runLater( () -> {
                contador.setText(segundos.toString());
            });
        };
        var alTerminar = (Runnable) () -> {
            // Hacer que pase la pregunta
        };
        modelo.comenzarRonda(alCambiar, alTerminar);

        this.getChildren().addAll(vistaTipoPregunta, contador);
    }

    public void CambiarPreguntaAOtroJugador(Kahoot modelo, Jugador jugador, Stage stage) {
        this.getChildren().clear();
        if(modelo.todosContestaron()) {
            if(modelo.esRondaFinal()) {
                VistaResultados vistaResultados = new VistaResultados(modelo,stage);
                this.getChildren().addAll(vistaResultados);
            }
            else {
                VistaRespuestas vistaRespuesta = new VistaRespuestas(modelo, stage);
                this.getChildren().addAll(vistaRespuesta);
            }
        }
        else{
            Jugador siguiente = jugador;
            for(Jugador jugadoraux : modelo.obtenerJugadores()){
                if(jugadoraux != jugador)
                    siguiente = jugadoraux;
            }
            VistaCambiarJugador vistaCambiarJugador = new VistaCambiarJugador(modelo, siguiente, stage);
            this.getChildren().addAll(vistaCambiarJugador);
        }
    }
}
