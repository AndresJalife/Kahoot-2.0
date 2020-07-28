package edu.fiuba.algo3.modelo.preguntas;

public class ModoClasico implements IModoDePregunta {

    @Override
    public int calcularPuntaje(int respuestasCorrectasTotales, int respuestasIncorrectasJugador, int respuestasCorrectasJugador) {
        /* Solo suma si tiene todas correctas */
        return respuestasCorrectasTotales == respuestasCorrectasJugador ? respuestasCorrectasJugador : 0;
    }
}
