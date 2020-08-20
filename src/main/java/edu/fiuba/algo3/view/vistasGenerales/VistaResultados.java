package edu.fiuba.algo3.view.vistasGenerales;

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
    StackPane stack;

    public VistaResultados(Kahoot modelo, Stage stage){

        this.crearGrid();
        actualizarResultadosYOrdenar(modelo);
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
        if (jugadores.get(0).obtenerPuntaje()==jugadores.get(1).obtenerPuntaje()) mostrarEmpate(jugadores);
        else{
        jugadores.sort((o1, o2) -> Integer.compare(o2.obtenerPuntaje(), o1.obtenerPuntaje()));
        this.mostrarGanador(jugadores);}
    }

    private void mostrarEmpate(List<Jugador> jugadores){
        Label titulo = new Label("Empate!");
        titulo.setTextFill(Color.rgb(238, 205, 134));
        titulo.setFont(new Font(50));
        Label texto= new Label("Ambos jugadores obtuvieron "+ jugadores.get(0).obtenerPuntaje()+" puntos");
        texto.setTextFill(Color.rgb(238, 205, 134));
        texto.setFont(new Font(25));
        stack = new StackPane();
        grid.add(titulo,20,20);
        stack.setMargin(titulo, new Insets(-200, -10, 0, 30));

        grid.add(texto,20,30);
    }

    private void mostrarGanador(List<Jugador> jugadores){
        int i = 20;

        for(Jugador jugador : jugadores){
            Label usuario;
            String  puntos = "PUNTOS";
            if (jugador.obtenerPuntaje() == 1) puntos = "PUNTO";

            if(i==20) usuario = new Label("¡¡ EL GANADOR ES "+ jugador.obtenerNombre()+" CON "+jugador.obtenerPuntaje()+ puntos +" !!" );
            else usuario = new Label("EN SEGUNDO PUESTO  "+ jugador.obtenerNombre()+" CON "+jugador.obtenerPuntaje()+ puntos );


            usuario.setFont(Font.font("Arial", FontWeight.BOLD, 35));
            usuario.setTextFill(Color.rgb(238, 205, 134));

            grid.add(usuario,20,i);
            i=i+10;
        }
    }
    private void obtenerColorDeFondo() {
        Color color = Color.rgb(122,62,72);
        grid.setBackground(new Background((new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY))));
    }
}
