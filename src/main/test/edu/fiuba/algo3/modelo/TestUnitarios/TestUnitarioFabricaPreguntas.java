package edu.fiuba.algo3.modelo.TestUnitarios;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestUnitarioFabricaPreguntas {

    FabricaDePreguntas fabrica = new FabricaDePreguntas();
    String textoPregunta = "PREGUNTA";
    Opcion opcion1 = new Opcion("opcion1", true);
    Opcion opcion2 = new Opcion("opcion2");
    Opcion opcion3 = new Opcion("opcion3");
    List<Opcion> opciones = new ArrayList<>();
    int tiempo = 1;
    int puntajePorRespuestas = 1;

    @Test
    public void crearPreguntaVerdaderoFalsoClasicoConExito(){
        opciones.add(opcion1);
        opciones.add(opcion2);
        Pregunta pregunta = fabrica.crearPregunta(textoPregunta,opciones,tiempo,puntajePorRespuestas,"VerdaderoFalso","Clasico");

        assertNotNull(pregunta);
    }

    @Test
    public void crearPreguntaVerdaderoFalsoConPenalidadConExito(){
        opciones.add(opcion1);
        opciones.add(opcion2);
        Pregunta pregunta = fabrica.crearPregunta(textoPregunta,opciones,tiempo,puntajePorRespuestas,"VerdaderoFalso","conPenalidad");

        assertNotNull(pregunta);
    }

    @Test
    public void crearPreguntaMultipleChoiceClasicoConExito(){
        opciones.add(opcion1);
        opciones.add(opcion2);
        Pregunta pregunta = fabrica.crearPregunta(textoPregunta,opciones,tiempo,puntajePorRespuestas,"MultipleChoice","clasico");

        assertNotNull(pregunta);
    }

    @Test
    public void crearPreguntaMultipleChoiceConPenalidadConExito(){
        opciones.add(opcion1);
        opciones.add(opcion2);
        Pregunta pregunta = fabrica.crearPregunta(textoPregunta,opciones,tiempo,puntajePorRespuestas,"MultipleChoice","conPenalidad");

        assertNotNull(pregunta);
    }

    @Test
    public void crearPreguntaConNombreDelTipoIncorrectoDevuelveNull(){
        opciones.add(opcion1);
        opciones.add(opcion2);
        Pregunta pregunta = fabrica.crearPregunta(textoPregunta,opciones,tiempo,puntajePorRespuestas,"verdadero y falso","conPenalidad");

        assertNull(pregunta);
    }

    @Test
    public void crearPreguntaConNombreDelModoIncorrectoDevuelveNull(){
        opciones.add(opcion1);
        opciones.add(opcion2);
        Pregunta pregunta = fabrica.crearPregunta(textoPregunta,opciones,tiempo,puntajePorRespuestas,"VerdaderoFalso","Penalidad");

        assertNull(pregunta);
    }
}
