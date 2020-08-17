package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.*;

public class VistaResultados extends StackPane{

    GridPane grid;

    public VistaResultados(Kahoot modelo, Stage stage){


        this.crearGrid();
        actualizarResultadosYOrdenar(modelo);
       // this.obtenerGanador(jugadores);
        this.obtenerColorDeFondo();
        this.getChildren().addAll(grid);
    }

    private void crearGrid(){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
    }

    void actualizarResultadosYOrdenar(Kahoot modelo){
        List<Jugador> jugadores = new ArrayList<>(modelo.obtenerJugadores());
        modelo.actualizarPuntaje();
        if (jugadores.get(0).obtenerPuntaje()==jugadores.get(1).obtenerPuntaje()){

        }
        jugadores.sort((o1, o2) -> Integer.compare(o2.obtenerPuntaje(), o1.obtenerPuntaje()));
        this.obtenerGanador(jugadores);

    }

    private void obtenerGanador(List<Jugador> jugadores){
        int i = 20;
        int j=0;
        for(Jugador jugador : jugadores){
            Label usuario;

            if(j==0) usuario = new Label("El ganador es: "+ jugador.obtenerNombre() );

            else usuario = new Label("El perdedor es: "+ jugador.obtenerNombre() );

            usuario.setFont(Font.font("Arial", FontWeight.BOLD, 35));
            grid.add(usuario,42,i);
            Label puntos = new Label(String.valueOf(jugador.obtenerPuntaje()));
            puntos.setFont(Font.font("Arial", FontWeight.BOLD, 35));
            grid.add(puntos,43,i);
            i++;
            j++;
        }
    }
    private void obtenerColorDeFondo() {
        Color color = Color.rgb(122,62,72);
        grid.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
