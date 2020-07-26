package edu.fiuba.algo3.modelo;

public class Opcion {
    private String textoamostrar;
    private Boolean estabien = false;

    public Opcion(String texto)
    {
        this.textoamostrar = texto;
    }

    public Opcion_Correcta()
    {
        this.estabien = true;
    }
}
