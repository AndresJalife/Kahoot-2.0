package edu.fiuba.algo3.modelo.preguntas;

public class Opcion {

    private String texto;
    private int grupo;
    private int grupoCorrecto;

    public Opcion(String text) {
        this(text, false);
    }

    public Opcion(String texto, boolean esVerdadera) {
        this.texto = texto;
        this.grupo = esVerdadera ? 1 : 0;
        this.grupoCorrecto = 1;
    }

    public Opcion(String texto, int grupo, int grupoQueSeDebeSeleccionar) {
        this.texto = texto;
        this.grupo = grupo;
        this.grupoCorrecto = grupoQueSeDebeSeleccionar;
    }

    public boolean esCorrecta() {
        return this.grupo == this.grupoCorrecto;
    }

    public boolean esCorrecta(int grupo) {
        return this.grupo == grupo && grupo == this.grupoCorrecto;
    }

    public String obtenerTexto() {
        return texto;
    }
}
