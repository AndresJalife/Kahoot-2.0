package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.Exclusividad;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Multiplicadorx2;
import edu.fiuba.algo3.modelo.Multiplicadorx3;
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
        assertEquals(Multiplicadorx2.CondicionesIniciales, jugador.obtenerMultiplicadorX2().getCantidad());
    }

    @Test
    public void CrearJugadorYObtenerMultiplicadorX3(){
        Jugador jugador = new Jugador("Alfredo");
        assertEquals(Multiplicadorx3.CondicionesIniciales, jugador.obtenerMultiplicadorX3().getCantidad());
    }

    @Test
    public void CrearJugadorYObtenerExclusividad(){
        Jugador jugador = new Jugador("Alfredo");
        assertEquals(Exclusividad.CondicionesIniciales, jugador.obtenerExclusividades().getCantidad());
    }
}
