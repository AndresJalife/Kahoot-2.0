package edu.fiuba.algo3.modelo.general;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.IModoDePregunta;
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

        List<Pregunta> nuevasPreguntas = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        var file = new File(nombreArchivo);
        JSONObject preguntasJSON = (JSONObject) jsonParser.parse(new FileReader(file));

        if (preguntasJSON.containsKey(TIPO_GROUPED)){
            agregarPreguntasGroup((JSONArray) preguntasJSON.get(TIPO_GROUPED), nuevasPreguntas);
            preguntasJSON.remove(TIPO_GROUPED);
        }
        agregarPreguntasNoGroup(preguntasJSON, nuevasPreguntas);

        return nuevasPreguntas;
    }

    private void agregarPreguntasNoGroup(JSONObject preguntasJSON, List<Pregunta> nuevasPreguntas) {
        FabricaDePreguntas fabrica = new FabricaDePreguntas();

        preguntasJSON.keySet().forEach(tipo ->{
            JSONObject pregunta = (JSONObject) preguntasJSON.get(tipo);
            String modo =  pregunta.get("modo").toString();
            String texto = (String) pregunta.get("texto");

            List<String> opciones = jsonArrToList((JSONArray) pregunta.get("opciones"));
            List<String> opcionesCorrectas = jsonArrToList((JSONArray) pregunta.get("opcionesCorrectas"));

            List<Opcion> opcionesConcretas = crearListaOpciones(opciones, opcionesCorrectas);

            Pregunta nuevaPreg = fabrica.crearPregunta(texto, opcionesConcretas, tipo.toString(), modo);
            nuevasPreguntas.add(nuevaPreg);
        });
    }

    private void agregarPreguntasGroup(JSONArray preguntasGroupChoice, List<Pregunta> nuevasPreguntas) {
        FabricaDePreguntas fabrica = new FabricaDePreguntas();
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
        Integer GRUPO_1 = 1;
        Integer GRUPO_2 = 2;

        JSONObject opcionesJson = (JSONObject) opciones;
        List<Opcion> listaOpciones = new ArrayList<>();

        List<Integer> grupos = new ArrayList<>();
        grupos.add(GRUPO_1);
        grupos.add(GRUPO_2);

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
