package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.general.Exclusividad;
import edu.fiuba.algo3.modelo.general.Jugador;
import edu.fiuba.algo3.modelo.general.Multiplicador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnitarioJugador {

    @Test
    public void CrearJugadorConNombre(){
        Jugador jugador = new Jugador("Juan Perez");
        assertTrue(true);
        // Prueba que deberia dar siempre positivo para ver confirmar si lo que falla son las pruebas o otra cosa
    }

    @Test
    public void CrearJugadorConNombreVacio(){
        Jugador jugador = new Jugador("");
        assertTrue(true);
    }

    @Test
    public void CrearJugadorYObtenerPuntajeRecienCreado(){
        Jugador jugador = new Jugador("Alfredo");
        assertEquals(0, jugador.obtenerPuntaje());
    }

    @Test
    public void CrearJugadorYObtenerMultiplicadorX2(){
        Jugador jugador = new Jugador("Alfredo");
        var multiplicador = new Multiplicador(2);
        assertEquals(multiplicador.obtenerCantidad(), jugador.obtenerMultiplicadorX2().obtenerCantidad());
    }

    @Test
    public void CrearJugadorYObtenerMultiplicadorX3(){
        Jugador jugador = new Jugador("Alfredo");
        var multiplicador = new Multiplicador(3);
        assertEquals(multiplicador.obtenerCantidad(), jugador.obtenerMultiplicadorX3().obtenerCantidad());
    }

    @Test
    public void CrearJugadorYObtenerExclusividad(){
        Jugador jugador = new Jugador("Alfredo");
        var exclusividad = new Exclusividad(2);
        assertEquals(exclusividad.obtenerCantidad(), jugador.obtenerExclusividades().obtenerCantidad());
    }
}
