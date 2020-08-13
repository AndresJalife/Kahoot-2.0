package edu.fiuba.algo3.modelo.preguntas;

public class Opcion {

    private String texto;
    private int grupo;

    public Opcion(String text) {
        this(text, 0);
    }

    public Opcion(String texto, boolean esVerdadera) {
        this.texto = texto;
        this.grupo = esVerdadera ? 1 : 0;
    }

    public Opcion(String texto, int grupo) {
        this.texto = texto;
        this.grupo = grupo;
    }

    public boolean esCorrecta() {
        return this.grupo == 1;
    }

    public boolean esCorrecta(int eleccion) {
        return this.grupo == eleccion;
    }

    public String obtenerTexto() {
        return texto;
    }
}
