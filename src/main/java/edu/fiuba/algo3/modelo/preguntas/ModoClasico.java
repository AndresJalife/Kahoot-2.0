package edu.fiuba.algo3.modelo.preguntas;

public class ModoClasico implements IModoDePregunta {

    @Override
    public int calcularPuntaje(int respuestasCorrectasTotales, int respuestasIncorrectasJugador, int respuestasCorrectasJugador) {
        /* Solo devuelve 1 si todas son correctas */
        if(respuestasCorrectasTotales == respuestasCorrectasJugador && respuestasIncorrectasJugador == 0)
            return 1;
        else return 0;
    }

    @Override
    public boolean tienePenalidad() {
        return false;
    }
}
