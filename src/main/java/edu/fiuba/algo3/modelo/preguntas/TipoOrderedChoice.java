package edu.fiuba.algo3.modelo.preguntas;

import java.util.List;

public class TipoOrderedChoice implements ITipoDePregunta{

    public TipoOrderedChoice() {
    }

    @Override
    public boolean opcionesValidas(List<Opcion> opciones) {
        return true;
    }
}
