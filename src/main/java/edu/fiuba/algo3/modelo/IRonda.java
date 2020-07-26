package edu.fiuba.algo3.modelo;

public interface IRonda {
    public void agregarExclusividad(IModificador exclusividad) throws MultiplicadorEnRondaExclusivaError ;
    public void agregarMultiplicador(IModificador multiplicador) throws ExclusividadEnRondaNormalError;
    public void actualizar(Jugador jugador);
}
