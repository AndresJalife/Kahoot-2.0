package edu.fiuba.algo3.view.vistasPreguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public abstract class VistaTipoDePregunta extends StackPane{
    protected Kahoot modelo;
    protected Jugador jugador;
    protected Stage stage;
    private Label nombreJugador;
    protected Label pregunta;
    private Label numeroDePregunta;



    public VistaTipoDePregunta(Kahoot modelo, Jugador jugador, Stage stage) {
        this.modelo = modelo;
        this.jugador = jugador;
        this.stage = stage;

        inicializarLabels();
        setStackPane();
        obtenerColorDeFondo();
    }
    public abstract void forzarContestar();

    private void inicializarLabels(){
        setAlignment(Pos.CENTER);

        numeroDePregunta = new Label( "Pregunta " + modelo.obtenerPreguntaActual().getNumeroDePregunta() + " / " + Pregunta.getNumeroTotalPreguntas());
        numeroDePregunta.setAlignment(Pos.TOP_LEFT);

        nombreJugador = new Label(jugador.obtenerNombre());
        nombreJugador.setFont(Font.font("Arial", FontWeight.BOLD, 35));

        pregunta = new Label(modelo.obtenerPreguntaActual().obtenerTexto());
        pregunta.setFont(new Font(25));
        pregunta.underlineProperty().setValue(true);
    }

    private void setStackPane() {
        this.getChildren().removeAll();

        getChildren().add(numeroDePregunta);
        setMargin(numeroDePregunta, new Insets(-700, -200, 0, 0));

        setAlignment(Pos.CENTER);

        getChildren().add(nombreJugador);
        setMargin(nombreJugador, new Insets(-600, 0, 0, 0));

        getChildren().add(pregunta);
        setMargin(pregunta, new Insets(-500, 0, 0, 0));

    }

    private void obtenerColorDeFondo() {
        Color color = Color.rgb(122,62,72);
        this.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
