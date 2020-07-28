package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
