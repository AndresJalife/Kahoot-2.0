package edu.fiuba.algo3.modelo.general;

import java.util.function.Consumer;

public class Cronometro {
    private int segundos;
    private CronometroThread thread;
    private Consumer<Integer> alCambiar;
    private Runnable alTerminar;

    public Cronometro(int segundos) {
        this.segundos = segundos;
        this.reset();
    }

    public void reset() {
        thread = new CronometroThread(segundos);
        thread.setAlCambiar(this.alCambiar);
        thread.setAlTerminar(this.alTerminar);
    }

    public void comenzar() {
        thread.start();
    }

    public void finalizar() {
        thread.finalizar();
    }

    public void setAlCambiar(Consumer<Integer> handler) {
        this.alCambiar = handler;
    }

    public void setAlTerminar(Runnable handler) {
        this.alTerminar = handler;
    }
}
