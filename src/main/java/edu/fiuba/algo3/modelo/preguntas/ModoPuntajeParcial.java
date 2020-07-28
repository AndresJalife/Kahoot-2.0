package edu.fiuba.algo3.modelo.preguntas;

public class ModoPuntajeParcial implements IModoDePregunta {

    @Override
    public int calcularPuntaje(int respuestasCorrectasTotales, int respuestasIncorrectasJugador, int respuestasCorrectasJugador) {
        /* Suma parcialmente */
        return respuestasCorrectasJugador * (1 - Math.min(respuestasIncorrectasJugador, 1));
    }

    @Override
    public boolean tienePenalidad() {
        return false;
    }
}
