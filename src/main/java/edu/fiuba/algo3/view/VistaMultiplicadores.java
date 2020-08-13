package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class VistaMultiplicadores extends StackPane {

    GridPane grid;

    public VistaMultiplicadores(Kahoot modelo, Jugador jugador){
        boolean nolequedanada;
        this.crearGrid(grid);
        if(modelo.obtenerPreguntaActual().tienePenalidad())
            nolequedanada = agregarMultiplicadores(grid, jugador);
        else
            nolequedanada = agregarExclusividad(grid, jugador);
        if(nolequedanada){
            // Skipear esta pantalla
        }
    }

    private void crearGrid(GridPane grid){
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
    }

    private boolean agregarMultiplicadores(GridPane grid, Jugador jugador){
        if(jugador.obtenerMultiplicadorX2().quedanUsos()){
            Button X2 = new Button("Usar multiplicador X2");
            grid.add(X2,1,1);
            return false;
        }
        if(jugador.obtenerMultiplicadorX3().quedanUsos()){
            Button X3 = new Button("Usar multiplicador X3");
            grid.add(X3,1,1);
            return false;
        }
        return true;
    }

    private boolean agregarExclusividad(GridPane grid, Jugador jugador){
        if(jugador.obtenerExclusividades().quedanUsos()){
            Button exclusividad = new Button("Usar exclusividad");
            grid.add(exclusividad,1,1);
            return false;
        }
        return true;
    }
}
