package edu.fiuba.algo3.modelo;

public class Opcion {
    private String textoamostrar;
    private Boolean estabien = false;

    public Opcion(String texto){ this.textoamostrar = texto; }

    public void Opcion_Correcta(){ this.estabien = true; }

    public Boolean Respuesta(){ return estabien; }

    public String obtenerTextoamostrar() {
        return textoamostrar;
    }
}
