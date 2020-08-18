package edu.fiuba.algo3.modelo.general;

import java.util.function.Consumer;

public class CronometroThread extends Thread {

    private int segundos;
    private Consumer<Integer> alCambiar;
    private Runnable alTerminar;

    public CronometroThread(int segundos) {
        this.segundos = segundos;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (segundos > 0) {
            segundos--;
            if (alCambiar != null)
                alCambiar.accept(segundos);
            esperar1Segundo();
        }
        if(alTerminar != null)
            alTerminar.run();
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

    public void setAlTerminar(Runnable handler) {
        this.alTerminar = handler;
    }
}
