package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.preguntas.VistaVerdaderoYFalso;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class VistaCambiarJugador extends StackPane {
    public VistaCambiarJugador(Kahoot modelo, Jugador jugador){
        this.getChildren().clear();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Button boton = new Button("Siguiente jugador");
        boton.setOnAction(actionEvent -> {
            VistaVerdaderoYFalso vistaVerdaderoYFalso = new VistaVerdaderoYFalso(modelo, jugador);
            this.getChildren().addAll(vistaVerdaderoYFalso);
            });

    }
}
