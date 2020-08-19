package edu.fiuba.algo3.modelo.general;

import java.util.function.Consumer;

public class Cronometro {
    private int segundos;
    private CronometroThread thread;
    private Consumer<Integer> alCambiar;
    private Runnable alTerminar;

    public Cronometro(int segundos) {
        this.segundos = segundos+1;
        this.reset();
    }

    public void reset() {
        thread = new CronometroThread(segundos);
    }

    public void comenzar() {
        thread.setAlCambiar(this.alCambiar);
        thread.setAlTerminar(this.alTerminar);
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

    public static class CronometroThread extends Thread {

        private int segundos;
        private volatile boolean cortar;
        private Consumer<Integer> alCambiar;
        private Runnable alTerminar;

        public CronometroThread(int segundos) {
            this.segundos = segundos;
            this.setDaemon(true);
        }

        @Override
        public void run() {
            while (segundos > 0) {
                if (cortar)
                    return;
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

        public void finalizar() {
            cortar = true;
        }

        public void setAlCambiar(Consumer<Integer> handler) {
            this.alCambiar = handler;
        }

        public void setAlTerminar(Runnable handler) {
            this.alTerminar = handler;
        }
    }
}
