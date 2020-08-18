package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.preguntas.FabricaDeVistasPregunta;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

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
        contador.setFont(Font.font("Arial", FontWeight.BOLD, 128));
        contador.setTextFill(Color.rgb(255, 255, 255));
        contador.setTranslateX(0);
        contador.setTranslateY(250);

        var alCambiar = (Consumer<Integer>) (segundos) -> {
            Platform.runLater( () -> {
                contador.setText(segundos.toString());
            });
        };
        var alTerminar = (Runnable) () -> {
            Platform.runLater(vistaTipoPregunta::forzarContestar);
        };

        modelo.comenzarRonda(alCambiar, alTerminar);

        this.getChildren().addAll(vistaTipoPregunta);
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
