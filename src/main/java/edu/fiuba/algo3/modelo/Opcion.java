package edu.fiuba.algo3.modelo;

public class Opcion {
    private String textoAMostrar;
    private Boolean estabien = false;

    public Opcion(String texto)
    {
        this.textoAMostrar = texto;
    }

    public void Opcion_Correcta()
    {
        this.estabien = true;
    }
}
