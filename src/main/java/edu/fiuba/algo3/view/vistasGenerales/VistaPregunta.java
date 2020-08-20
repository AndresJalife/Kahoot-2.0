package edu.fiuba.algo3.view.vistasGenerales;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.vistasPreguntas.FabricaDeVistasPregunta;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class VistaPregunta extends Group {

    private final FabricaDeVistasPregunta fabrica;
    private StackPane stackPanePregunta;

    public VistaPregunta() {
        fabrica = new FabricaDeVistasPregunta();
    }

    public VistaPregunta(Kahoot modelo , Jugador jugador, Stage stage) {
        this();

        stackPanePregunta = new StackPane();
        StackPane.setAlignment(this, Pos.CENTER);
        stackPanePregunta.setPrefSize(stage.getWidth(),stage.getHeight());

        var vistaTipoPregunta = fabrica.crearVistaTipoDePregunta(modelo, jugador, stage);
        vistaTipoPregunta.setPrefSize(stage.getWidth(),stage.getHeight());
        vistaTipoPregunta.setAlignment(Pos.CENTER);

        var contador = new Label();

        contador.setFont(Font.font("Arial", FontWeight.BOLD, 100));
        contador.setTextFill(Color.rgb(255, 255, 255));
        contador.setTranslateX(0);
        contador.setTranslateY(150);

        AudioClip sonidoCronometro = new AudioClip(this.getClass().getResource("/sonidos/timerClick.mp3").toExternalForm());

        sonidoCronometro.setVolume(100);
        var alCambiar = (Consumer<Integer>) (segundos) -> {
            Platform.runLater( () -> {
                contador.setText(segundos.toString());
                sonidoCronometro.play();

            });
        };
        var alTerminar = (Runnable) () -> {
            Platform.runLater(vistaTipoPregunta::forzarContestar);
        };

        modelo.comenzarRonda(alCambiar, alTerminar);
        stackPanePregunta.getChildren().addAll(vistaTipoPregunta,contador);
        this.getChildren().add(stackPanePregunta);
    }

    public void CambiarPreguntaAOtroJugador(Kahoot modelo, Jugador jugador, Stage stage) {
        this.getChildren().clear();
        modelo.finalizarRonda();
        if(modelo.todosContestaron()) {
            if(modelo.esRondaFinal()) {
                VistaResultados vistaResultados = new VistaResultados(modelo,stage);
                vistaResultados.setAlignment(this, Pos.CENTER);
                vistaResultados.setPrefSize(stage.getWidth(),stage.getHeight());
                this.getChildren().addAll(vistaResultados);
            }
            else {
                VistaRespuestas vistaRespuesta = new VistaRespuestas(modelo, stage);
                vistaRespuesta.setAlignment(this, Pos.CENTER);
                vistaRespuesta.setPrefSize(stage.getWidth(),stage.getHeight());
                this.getChildren().addAll(vistaRespuesta);
            }
        }
        else{
            Jugador siguiente = jugador;
            for(Jugador jugadoraux : modelo.obtenerJugadores()){
                if(jugadoraux != jugador)
                    siguiente = jugadoraux;
            }
            var vistaCambiarJugador = new VistaCambiarJugador(modelo, siguiente, stage);
            vistaCambiarJugador.setAlignment(this, Pos.CENTER);
            vistaCambiarJugador.setPrefSize(stage.getWidth(),stage.getHeight());
            this.getChildren().addAll(vistaCambiarJugador);
        }
    }
}
