package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.eventos.SiguienteRondaOTerminar;
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
        this.crearGrid();
        List<Jugador> jugadores = actualizarResultadosYOrdenar(modelo);
        this.obtenerNombresConPuntos(grid, jugadores);
        if(modelo.cambiarRonda()){
            Button siguientePregunta = new Button("Siguiente pregunta");
            siguientePregunta.setOnAction(new SiguienteRondaOTerminar(modelo, stage));
            grid.add(siguientePregunta,1,4);
        }
        this.getChildren().addAll(grid);
    }

    private void crearGrid(){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
    }

    private List<Jugador> actualizarResultadosYOrdenar(Kahoot modelo){
        List<Jugador> jugadores = new ArrayList<>(modelo.obtenerJugadores());
        modelo.actualizarPuntaje();
        jugadores.sort((o1, o2) -> Integer.compare(o2.obtenerPuntaje(), o1.obtenerPuntaje()));
        return jugadores;
    }

    private void obtenerNombresConPuntos(GridPane grid, List<Jugador> jugadores){
        int i = 1;
        for(Jugador jugador : jugadores){
            Label usuario = new Label(jugador.obtenerNombre() + " ->");
            grid.add(usuario,1,i);
            Label puntos = new Label(String.valueOf(jugador.obtenerPuntaje()));
            grid.add(puntos,2,i);
            i++;
        }
    }
}
