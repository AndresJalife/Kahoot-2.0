package edu.fiuba.algo3.view.vistasGenerales;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.TipoGroupChoice;
import edu.fiuba.algo3.view.eventos.SiguienteRondaOTerminar;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.*;

public class VistaRespuestas extends StackPane {
    StackPane stack;

    public VistaRespuestas(Kahoot modelo, Stage stage){
        stack = new StackPane();
        this.getStylesheets().add(getClass().getResource("/css/escenaGeneral.css").toExternalForm());
        List<Jugador> jugadores = actualizarResultadosYOrdenar(modelo);
        this.obtenerNombresConPuntos(jugadores);
        this.mostrarRespuestasCorrectas(modelo);
        if(modelo.cambiarRonda()){
            Button siguientePregunta = new Button("Siguiente pregunta");
            siguientePregunta.setOnAction(new SiguienteRondaOTerminar(modelo, stage));
            stack.getChildren().add(siguientePregunta);
            stack.setMargin(siguientePregunta, new Insets(100, 0, 0, 0));
        }
        this.obtenerColorDeFondo();
        this.getChildren().add(stack);
    }

    private void mostrarRespuestasCorrectas(Kahoot modelo) {
        List<Opcion> respuestasCorrectas = modelo.obtenerPreguntaActual().obtenerRespuestasCorrectas();
        String tituloString = "Las respuestas correctas eran:";
        String correctasString = "- ";

        for (Opcion opcion: respuestasCorrectas){
            if (modelo.obtenerPreguntaActual().obtenerTipo().getClass() == TipoGroupChoice.class){
                correctasString += opcion.obtenerTexto() + " = " + opcion.obtenerGrupo() + " - ";
            } else {
                correctasString += opcion.obtenerTexto() + " - ";
            }
        }

        Label titulo = new Label(tituloString);
        titulo.setFont(new Font(40));
        stack.setMargin(titulo, new Insets(-600, 0, 0, 0));

        Label correctas = new Label(correctasString);
        titulo.setFont(new Font(30));
        stack.setMargin(correctas, new Insets(-500, 0, 0, 0));
        stack.getChildren().addAll(titulo, correctas);
    }

    private List<Jugador> actualizarResultadosYOrdenar(Kahoot modelo){
        List<Jugador> jugadores = new ArrayList<>(modelo.obtenerJugadores());
        modelo.actualizarPuntaje();
        jugadores.sort((o1, o2) -> Integer.compare(o2.obtenerPuntaje(), o1.obtenerPuntaje()));
        return jugadores;
    }

    private void obtenerNombresConPuntos(List<Jugador> jugadores){
        int ALTO = -300;
        for(Jugador jugador : jugadores){
            Label usuario = new Label(jugador.obtenerNombre() + "     ->");
            usuario.setFont(Font.font("Arial", FontWeight.BOLD, 35));
            stack.getChildren().add(usuario);
            stack.setMargin(usuario, new Insets(ALTO, 200, 0, 0));

            Label puntos = new Label(String.valueOf(jugador.obtenerPuntaje()));
            puntos.setFont(Font.font("Arial", FontWeight.BOLD, 35));
            stack.getChildren().add(puntos);
            stack.setMargin(puntos, new Insets(ALTO, -250, 0, 0));
            ALTO += 200;
        }
    }
    private void obtenerColorDeFondo() {
        Color color = Color.rgb(122,62,72);
        stack.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
