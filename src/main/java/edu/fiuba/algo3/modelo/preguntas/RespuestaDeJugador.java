package edu.fiuba.algo3.modelo.preguntas;

public class RespuestaDeJugador {

    private int grupoElegido;
    private Opcion opcion;

    /*
    * Si no recibimos un grupo por default tomamos el grupo de la opcion elegida.
    * Verdadero = Grupo 1, Falso = Grupo 0
    * */
    public RespuestaDeJugador(Opcion opcion) {
        this.opcion = opcion;
        this.grupoElegido = 1;
    }

    public RespuestaDeJugador(Opcion opcion, int grupoElegido) {
        this.opcion = opcion;
        this.grupoElegido = grupoElegido;
    }

    public boolean esCorrecta() {
        return opcion.esCorrecta(grupoElegido);
    }

    public String obtenerTexto() {
        return opcion.obtenerTexto();
    }

    public void setGrupoElegido(int nuevoValor) {
        grupoElegido = nuevoValor;
    }

    public int getGrupoElegido() {
        return grupoElegido;
    }
}
