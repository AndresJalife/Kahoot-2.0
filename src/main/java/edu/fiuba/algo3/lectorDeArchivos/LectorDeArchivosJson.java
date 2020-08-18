package edu.fiuba.algo3.lectorDeArchivos;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


import edu.fiuba.algo3.modelo.general.LectorDeArchivos;
import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class LectorDeArchivosJson implements LectorDeArchivos {
    @Override
    public List<Pregunta> crearListaDePreguntas(URI nombreArchivo) throws IOException, ParseException {
        String TIPO_GROUPED = "GroupChoice";
        String TIPO_ORDERED = "OrderedChoice";
        FabricaDePreguntas fabrica = new FabricaDePreguntas();

        List<Pregunta> nuevasPreguntas = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        var file = new File(nombreArchivo);
        JSONObject preguntasJSON = (JSONObject) jsonParser.parse(new FileReader(file));

        if (preguntasJSON.containsKey(TIPO_GROUPED)){
            agregarPreguntasGroupYOrdered((JSONArray) preguntasJSON.get(TIPO_GROUPED), nuevasPreguntas, fabrica);
            preguntasJSON.remove(TIPO_GROUPED);
        }
        if (preguntasJSON.containsKey(TIPO_ORDERED)){
            agregarPreguntasGroupYOrdered((JSONArray) preguntasJSON.get(TIPO_ORDERED), nuevasPreguntas, fabrica);
            preguntasJSON.remove(TIPO_ORDERED);
        }
        System.out.println(preguntasJSON);
        agregarPreguntasRestantes(preguntasJSON, nuevasPreguntas, fabrica);

        return nuevasPreguntas;
    }

    private void agregarPreguntasRestantes(JSONObject preguntasJSON, List<Pregunta> nuevasPreguntas, FabricaDePreguntas fabrica) {
        preguntasJSON.keySet().forEach(tipo -> {
            JSONArray preguntasDelMismoTipo = (JSONArray) preguntasJSON.get(tipo);
            for (Object preguntaObject : preguntasDelMismoTipo){
                JSONObject pregunta = (JSONObject) preguntaObject;
                String modo = pregunta.get("modo").toString();
                String texto = (String) pregunta.get("texto");

                List<String> opciones = jsonArrToList((JSONArray) pregunta.get("opciones"));
                List<String> opcionesCorrectas = jsonArrToList((JSONArray) pregunta.get("opcionesCorrectas"));

                List<Opcion> opcionesConcretas = crearListaOpciones(opciones, opcionesCorrectas);

                Pregunta nuevaPreg = fabrica.crearPregunta(texto, opcionesConcretas, tipo.toString(), modo);
                nuevasPreguntas.add(nuevaPreg);
           }
        });
    }

    private void agregarPreguntasGroupYOrdered(JSONArray preguntasGroupChoice, List<Pregunta> nuevasPreguntas, FabricaDePreguntas fabrica) {
        for (Object objetoPregunta : preguntasGroupChoice){
            JSONObject pregunta = (JSONObject) objetoPregunta;
            String modo =  pregunta.get("modo").toString();
            String texto = (String) pregunta.get("texto");
            List<Opcion>  opciones = crearListaOpcionesGroup(pregunta.get("opciones"));
            Pregunta nuevaPreg = fabrica.crearPregunta(texto, opciones,"GroupChoice", modo);
            nuevasPreguntas.add(nuevaPreg);
        }

    }

    private List<Opcion> crearListaOpcionesGroup(Object opciones) {
        List<Integer> grupos = new ArrayList<>();
        int[] range = {1, 2, 3, 4};
        for (int GROUP: range){ grupos.add(GROUP);}

        JSONObject opcionesJson = (JSONObject) opciones;
        List<Opcion> listaOpciones = new ArrayList<>();

        for (Integer grupo: grupos){
            List<String> grupoActual = jsonArrToList((JSONArray) opcionesJson.get(grupo.toString()));
            for (String opcion: grupoActual){
                Opcion op = new Opcion(opcion, grupo, grupo);
                listaOpciones.add(op);
            }
        }
        return listaOpciones;
    }

    private List<Opcion> crearListaOpciones(List<String> opciones, List<String> opcionesCorrectas) {
        List<Opcion> listaDeOp = new ArrayList<>();
        for(String opcion: opciones){
            boolean esCorrecta = opcionesCorrectas.contains(opcion);
            listaDeOp.add(new Opcion(opcion, esCorrecta));
        }
        return listaDeOp;
    }

    private List<String> jsonArrToList(JSONArray jsonArray) {
        List<String> listaOp = new ArrayList<>();
        if (jsonArray != null) {
            int len = jsonArray.size();
            for (Object o : jsonArray) {
                listaOp.add(o.toString());
            }
        }
        return listaOp;
    }
}
