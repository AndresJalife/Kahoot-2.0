package edu.fiuba.algo3.modelo.general;

public class Cronometro {
    private int segundos;
    private CronometroThread thread;
    private boolean estaCorriendo;
    private boolean termino;

    public Cronometro(int segundos) {
        this.segundos = segundos;
        this.reset();
    }

    public void reset() {
        thread = new CronometroThread(segundos);
        thread.setAlCambiar(this::alCambiar);
    }

    public void comenzar() {
        estaCorriendo = true;
        thread.start();
    }

    private void alCambiar(int segundos) {
        if (this.segundos == 0) {
            estaCorriendo = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(segundos);
    }
}
