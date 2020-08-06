package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.*;

public class VistaRespuestas extends StackPane {

    public VistaRespuestas(Kahoot modelo){
        this.getChildren().clear();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        List<Jugador> jugadores = new ArrayList<>();
        List<Jugador> jugadoresOrdenados = new ArrayList<>();

        jugadores.addAll(modelo.obtenerJugadores());
        modelo.actualizarPuntaje();
        Collections.sort(jugadores, (o1, o2) -> {
            if(o1.obtenerPuntaje() > o2.obtenerPuntaje()) return -1;
            if(o1.obtenerPuntaje() < o2.obtenerPuntaje()) return 1;
            return 0;
        });

        int i = 1;
        for(Jugador jugador : jugadoresOrdenados){
            Label usuario = new Label(jugador.obtenerNombre());
            grid.add(usuario,i,1);
            Label puntos = new Label(String.valueOf(jugador.obtenerPuntaje()));
            grid.add(usuario,i,2);
            i++;
        }
    }
}
