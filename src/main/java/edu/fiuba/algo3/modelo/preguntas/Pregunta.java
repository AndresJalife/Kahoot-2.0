package edu.fiuba.algo3.modelo.preguntas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pregunta {
    public final static int TIEMPO = 15;
    private String textoPregunta;
    private List<Opcion> respuestasPosibles;
    private ITipoDePregunta tipo;
    private IModoDePregunta modo;
    private static int numeroTotalPreguntas;
    private int numeroDePregunta;
    public Pregunta(String textoPregunta, List<Opcion> opcionesPosibles, ITipoDePregunta tipo, IModoDePregunta modo) {
        this.textoPregunta = textoPregunta;
        this.respuestasPosibles = List.copyOf(opcionesPosibles);
        this.tipo = tipo;
        this.modo = modo;
        if(esPreguntaValida()){
            numeroTotalPreguntas ++;
            numeroDePregunta = numeroTotalPreguntas;
        }

    }

    public int getNumeroDePregunta() {
        return numeroDePregunta;
    }

    public static int getNumeroTotalPreguntas() {
        return numeroTotalPreguntas;
    }

    public boolean esPreguntaValida(){
        return tipo.opcionesValidas(respuestasPosibles);
    }
    public boolean tienePenalidad()
    {
        return modo.tienePenalidad();
    }

    public String obtenerTexto()
    {
        return textoPregunta;
    }

    public List<Opcion> obtenerOpciones() {
        return respuestasPosibles;
    }

    public List<Opcion> obtenerRespuestasCorrectas() {
        List<Opcion> respuestas = new ArrayList<>();
        for(Opcion opcion : respuestasPosibles) {
            if(opcion.esCorrecta())
                respuestas.add(opcion);
        }
        return respuestas;
    }

    public int calcularPuntaje(List<RespuestaDeJugador> respuestasJugador) {
        var respuestasCorrectas = obtenerRespuestasCorrectas();
        var totalCorrectas = respuestasCorrectas.size();
        var correctas = tipo.cantCorrectas(respuestasPosibles, respuestasJugador);
        var incorrectas = tipo.cantIncorrectas(respuestasPosibles, respuestasJugador);

        return modo.calcularPuntaje(totalCorrectas, incorrectas, correctas);
    }

    public ITipoDePregunta obtenerTipo() {
        return tipo;
    }

    public List<Opcion> obtenerOpcionesMezcladas() {
        List<Opcion> opcionesMezcladas = new ArrayList<>(List.copyOf(respuestasPosibles));
        Collections.shuffle(opcionesMezcladas);
        return opcionesMezcladas;
    }
}
