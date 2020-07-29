package edu.fiuba.algo3.modelo.preguntas;

import java.io.*;

public class ModoPuntajeParcialConPenalidad implements IModoDePregunta{

    @Override
    public int calcularPuntaje(int respuestasCorrectasTotales, int respuestasIncorrectasJugador, int respuestasCorrectasJugador) {
        return (respuestasCorrectasJugador - respuestasIncorrectasJugador);
    }

    @Override
    public boolean tienePenalidad() {
            return true;
        }
}
