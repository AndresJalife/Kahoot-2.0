package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.modelo.general.IModificador;
import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.VistaMultiplicadores;
import edu.fiuba.algo3.view.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TerminarVistaModificadores implements EventHandler<ActionEvent> {
    private Kahoot modelo;
    private Stage stage;
    private Jugador jugadorActual;

    public TerminarVistaModificadores(Kahoot miModelo, Stage miStage, Jugador jugadorAct, IModificador modificador) {
        modelo = miModelo;
        stage = miStage;
        jugadorActual = jugadorAct;
        this.agregarModificadores(modelo, jugadorAct, modificador);
    }

    private void agregarModificadores(Kahoot modelo, Jugador jugadorAct, IModificador modificador) {
        if (modificador != null){
            modelo.utilizarModificador(jugadorAct, modificador,true);
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (modelo.todosLosJugadoresEligieronModificadores()){
            System.out.println(modelo.obtenerJugadores().size());
            Scene escenaPregunta = new Scene(new VistaPregunta(modelo, modelo.obtenerJugadores().get(0), stage));
            stage.setScene(escenaPregunta);
        } else {
            for(Jugador jugador :modelo.obtenerJugadores()){
                if (jugadorActual != jugador){
                    Scene escenaMultiplicador = new Scene(new VistaMultiplicadores(modelo, stage, jugador));
                    stage.setScene(escenaMultiplicador);
                }
            }
        }
    }
}
