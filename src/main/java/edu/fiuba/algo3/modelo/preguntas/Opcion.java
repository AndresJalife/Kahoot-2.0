package edu.fiuba.algo3.modelo.preguntas;

public class Opcion {

    private String texto;
    private boolean esCorrecta;

    public Opcion(String text) {
        this(text, false);
    }

    public Opcion(String texto, boolean esCorrecta) {
        this.texto = texto;
        this.esCorrecta = esCorrecta;
    }

    public boolean esCorrecta() {
        return this.esCorrecta;
    }

    public String obtenerTexto() {
        return texto;
    }
}
