package edu.fiuba.algo3.view.vistasPreguntas;

import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.stage.Stage;

public class FabricaDeVistasPregunta {
    public VistaTipoDePregunta crearVistaTipoDePregunta(Kahoot modelo, Jugador jugador, Stage stage){
        ITipoDePregunta tipo = modelo.obtenerPreguntaActual().obtenerTipo();
        if (tipo.getClass().equals(TipoVerdaderoYFalso.class)){
            return (new VistaVerdaderoYFalso(modelo,jugador, stage));
        }else if(tipo.getClass().equals(TipoMultipleChoice.class)){
            return new VistaMultipleChoice(modelo,jugador, stage);
        }else if(tipo.getClass().equals(TipoOrderedChoice.class)){
            return new VistaOrderedChoice(modelo,jugador, stage);
        }else if(tipo.getClass().equals(TipoGroupChoice.class)){
            return new VistaGroupChoice(modelo,jugador, stage);
        }else return null;
    }
}
