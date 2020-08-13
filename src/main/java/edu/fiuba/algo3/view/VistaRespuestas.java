package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.preguntas.VistaVerdaderoYFalso;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.*;

public class VistaRespuestas extends StackPane {
    GridPane grid;

    public VistaRespuestas(Kahoot modelo, Stage stage){
        this.getChildren().clear();
        this.crearGrid();

        List<Jugador> jugadores = new ArrayList<>(modelo.obtenerJugadores());
        modelo.actualizarPuntaje();
        jugadores.sort((o1, o2) -> Integer.compare(o2.obtenerPuntaje(), o1.obtenerPuntaje()));

        int i = 1;
        for(Jugador jugador : jugadores){
            Label usuario = new Label(jugador.obtenerNombre() + " ->");
            grid.add(usuario,1,i);
            Label puntos = new Label(String.valueOf(jugador.obtenerPuntaje()));
            grid.add(puntos,2,i);
            i++;
        }
        Button siguientePregunta = new Button("Siguiente pregunta");
        siguientePregunta.setOnAction(actionEvent -> {
            if(modelo.cambiarRonda()){
                this.getChildren().clear();
                VistaPregunta vistaPregunta = new VistaPregunta(modelo, modelo.obtenerJugadores().get(0),stage);
                this.getChildren().addAll(vistaPregunta);
            }
            else{
                Alert ganador = new Alert(Alert.AlertType.INFORMATION);
                ganador.setHeaderText("El ganador es : ");
                ganador.showAndWait();
                /*this.getChildren().clear();
                VistaMenu vistaMenu = new VistaMenu(modelo, );
                this.getChildren().addAll(vistaMenu);11*/
            }
        });
        grid.add(siguientePregunta,1,4);
        this.getChildren().addAll(grid);
    }

    private void crearGrid(){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
    }

    private void actualizarResultadosYMostrar(){

    }
}
