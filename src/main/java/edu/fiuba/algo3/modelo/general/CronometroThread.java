package edu.fiuba.algo3.modelo.general;

import java.util.function.Consumer;

public class CronometroThread extends Thread {

    private int segundos;
    private Consumer<Integer> alCambiar;

    public CronometroThread(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public void run() {
        segundos--;
        if(this.alCambiar != null)
            this.alCambiar.accept(this.segundos);
        esperar1Segundo();
    }

    private void esperar1Segundo() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setAlCambiar(Consumer<Integer> handler) {
        this.alCambiar = handler;
    }
}
