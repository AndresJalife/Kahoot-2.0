package edu.fiuba.algo3.view.vistasGenerales;

import edu.fiuba.algo3.modelo.general.IModificador;
import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Kahoot;
import edu.fiuba.algo3.view.eventos.NoUsaModificador;
import edu.fiuba.algo3.view.eventos.UsaModificador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;

public class VistaMultiplicadores extends StackPane {

    StackPane stack;

    public VistaMultiplicadores(Kahoot modelo, Stage stage, Jugador jugador) {
        List<IModificador> modificadores = modelo.obtenerModificadores(jugador);
        boolean noTieneMasModificadores = true;
        for(IModificador modificador : modificadores){
            if(modificador.quedanUsos()) noTieneMasModificadores = false;
        }
        if(noTieneMasModificadores)
            if(jugador == modelo.obtenerSegundoJugador())
                this.getChildren().add(new VistaPregunta(modelo, modelo.obtenerPrimerJugador(), stage));
            else
                this.getChildren().add(new VistaMultiplicadores(modelo, stage, modelo.obtenerSegundoJugador()));
        else{
            stack = new StackPane();
            this.obtenerColorDeFondo(stack);
            this.getStylesheets().add(getClass().getResource("/css/escenaGeneral.css").toExternalForm());
            this.agregarModificadores(modelo, stack, stage, jugador);
        }
    }

    private void agregarModificadores(Kahoot modelo, StackPane stack, Stage stage, Jugador jugador){
        this.getChildren().clear();
        this.obtenerNombreYTitulo(jugador);
        int i = -400;
        this.obtenerBotonesDeModificadores(modelo,jugador,stage, i);
        this.obtenerBotonDePasar(modelo, jugador, stage, i);
        this.getChildren().addAll(stack);
    }

    private void obtenerNombreYTitulo(Jugador jugador){
        Label nombreJugador = new Label(jugador.obtenerNombre());
        nombreJugador.setFont(Font.font("Arial", FontWeight.BOLD, 35));
        stack.getChildren().addAll(nombreJugador);
        setMargin(nombreJugador, new Insets(-600, 0, 0, 0));
        Label titulo = new Label("Elija el modificador para la siguiente ronda:");
        titulo.setFont(new Font(20));
        stack.getChildren().addAll(titulo);
        stack.setMargin(titulo, new Insets(-500, 0, 0, 0));
    }

    private void obtenerBotonesDeModificadores(Kahoot modelo, Jugador jugador, Stage stage, int i){
        List<IModificador> modificadores = modelo.obtenerModificadores(jugador);

        for (IModificador modificador : modificadores) {
            Button boton = new Button(modificador.obtenerNombre());
            boton.setOnAction(new UsaModificador(modelo, jugador, modificador, stage));
            stack.getChildren().addAll(boton);
            stack.setMargin(boton, new Insets(i, 0, 0, 0));
            i += 200;
        }
    }

    private void obtenerBotonDePasar(Kahoot modelo, Jugador jugador, Stage stage, int i){
        Button boton = new Button("Pasar");
        boton.setOnAction(new NoUsaModificador(modelo, jugador, stage));
        stack.getChildren().addAll(boton);
        stack.setMargin(boton, new Insets(0, 0, 0, 0));
    }

    private void obtenerColorDeFondo(StackPane stack) {
        Color color = Color.rgb(122,62,72);
        stack.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
