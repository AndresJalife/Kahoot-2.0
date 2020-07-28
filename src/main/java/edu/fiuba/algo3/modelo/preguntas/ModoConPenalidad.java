package edu.fiuba.algo3.modelo.preguntas;

public class ModoConPenalidad implements IModoDePregunta {

    @Override
    public int calcularPuntaje(int respuestasCorrectasTotales, int respuestasIncorrectasJugador, int respuestasCorrectasJugador) {
        /* Suma puntos por correctas y resta por incorrectas */
        return respuestasCorrectasJugador - respuestasIncorrectasJugador;
    }
}
