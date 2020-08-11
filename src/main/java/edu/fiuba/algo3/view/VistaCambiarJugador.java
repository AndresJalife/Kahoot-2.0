package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.preguntas.VistaVerdaderoYFalso;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class VistaCambiarJugador extends StackPane {
    public VistaCambiarJugador(Kahoot modelo, Jugador jugador){
        this.getChildren().clear();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        if(modelo.todosContestaronMenosUno()){
            VistaRespuestas vistaRespuesta = new VistaRespuestas(modelo);
            this.getChildren().addAll(vistaRespuesta);
        }
        else{
            Jugador siguiente = jugador;
            for(Jugador jugadoraux : modelo.obtenerJugadores()){
                if(jugadoraux != jugador)
                    siguiente = jugadoraux;
            }
            VistaVerdaderoYFalso vistaTipoPregunta = new VistaVerdaderoYFalso(modelo, siguiente);
            this.getChildren().addAll(vistaTipoPregunta);
            }
    }
}
