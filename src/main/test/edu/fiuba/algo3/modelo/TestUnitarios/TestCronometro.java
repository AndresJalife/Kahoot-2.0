package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.general.Cronometro;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCronometro {

    @Test
    public void TestCronometroTardaSegundos() throws InterruptedException {
        var difference = new AtomicInteger();
        var start = System.currentTimeMillis();
        var cronometro = new Cronometro(1);
        cronometro.setAlTerminar(() -> difference.set(Math.round((System.currentTimeMillis() - start) / 1000f)));
        cronometro.comenzar();
        Thread.sleep(2000);
        assertEquals(1, difference.get());
    }

    @Test
    public void TestCronometroLlamaCallbackAlFinalizar() throws InterruptedException {
        var seLlamo = new AtomicBoolean();
        var cronometro = new Cronometro(1);
        cronometro.setAlTerminar(() -> seLlamo.set(true));
        cronometro.comenzar();
        Thread.sleep(2000);
        assertTrue(seLlamo.get());
    }

    @Test
    public void TestCronometroLlamaCadaSegundo() throws InterruptedException {
        var llamados = new AtomicInteger();
        var cronometro = new Cronometro(2);
        cronometro.setAlCambiar((s) -> llamados.getAndIncrement());
        cronometro.comenzar();
        Thread.sleep(3000);
        assertEquals(2, llamados.get());
    }

    @Test
    public void TestCronometroSePuedeCortar() throws InterruptedException {
        var llamados = new AtomicInteger();
        var cronometro = new Cronometro(3);
        cronometro.setAlCambiar((s) -> llamados.getAndIncrement());
        cronometro.comenzar();
        Thread.sleep(2000);
        cronometro.finalizar();
        Thread.sleep(2000);
        assertEquals(2, llamados.get());
    }

    @Test
    public void TestCronometroSePuedeResetear() throws InterruptedException {
        var llamados = new AtomicInteger();
        var cronometro = new Cronometro(1);
        cronometro.setAlCambiar((s) -> llamados.getAndIncrement());
        cronometro.comenzar();
        Thread.sleep(2000);
        cronometro.reset();
        cronometro.comenzar();
        Thread.sleep(2000);
        assertEquals(2, llamados.get());
    }
}
