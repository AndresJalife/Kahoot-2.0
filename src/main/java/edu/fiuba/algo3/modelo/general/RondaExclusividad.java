package edu.fiuba.algo3.modelo.general;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.List;

public class RondaExclusividad extends RondaBase {
    private List<Exclusividad> exclusividades;

    public RondaExclusividad(Pregunta pregunta, List<Jugador> jugadores) {
        super(pregunta, jugadores);
    }

    @Override
    public void mostrarModificadores(Jugador jugador) {
        Exclusividad exclusividad = jugador.obtenerExclusividades();
        if (exclusividad.quedanUsos()){
            System.out.format("Exclusividad. %d restantes", exclusividad.obtenerCantidad());
        }
        //  exclusividades.adds(exclusividad)
        //        MOSTRAR POR PANTALLA BOTON DE EXCLUSIVIDAD SOLO SI LE QUEDAN USOS
        //        HAY QUE AGREGARLOS A LA LISTA DE EXCLUSIVIDADES
    }
    
    
    public void actualizar() {
        int cantidadDeGanadores = 0;
        Jugador ganador = null;
        int puntajeRespuesta = 0;
        
        for (Jugador jugador : jugadores){
            var respuestas = respuestasDeJugadores.get(jugador);
            int puntajeActual = this.preguntaActual.calcularPuntaje(respuestas);
            if (puntajeActual > 0){
                cantidadDeGanadores += 1;
                ganador = jugador;
                puntajeRespuesta = puntajeActual;
            }
        }
        
        if (cantidadDeGanadores == 1){
            int puntajeFinal = 0;
            for (Exclusividad exclusividad :exclusividades){
                puntajeFinal += exclusividad.modificarPuntaje(puntajeRespuesta);
            }
            ganador.agregarPuntaje(puntajeFinal);
        }
    }

    @Override
    public void comenzar() {
        for (Jugador jugador:jugadores) {
            this.obtenerPreguntaActual();
            this.mostrarModificadores(jugador);
            this.obtenerPosiblesRespuestas();
            this.pedirRespuesta(jugador);
        }
        this.actualizar();
        this.obtenerRespuestasCorrectas();
    }

}
