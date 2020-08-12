package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.general.LectorDeArchivos;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class LectorDeArchivosJson implements LectorDeArchivos {
    @Override
    public List<Pregunta> crearListaDePreguntas(String nombreArchivo) throws IOException, ParseException {
        String TIPO_GROUPED = "GroupChoice";
        String TIPO_ORDERED = "OrderedChoice";

        List<Pregunta> nuevasPreguntas = new ArrayList<Pregunta>();
        JSONParser jsonParser = new JSONParser();
        JSONObject preguntasJSON = (JSONObject) jsonParser.parse(new FileReader(nombreArchivo));

        agregarPreguntasGroup((JSONArray) preguntasJSON.get(TIPO_GROUPED), nuevasPreguntas);
        preguntasJSON.remove(TIPO_GROUPED);

        preguntasNoGroup(preguntasJSON, nuevasPreguntas);



        return nuevasPreguntas;
    }

    private void preguntasNoGroup(JSONObject preguntasJSON, List<Pregunta> nuevasPreguntas) {
        FabricaDePreguntas fabrica = new FabricaDePreguntas();

        preguntasJSON.keySet().forEach(tipo ->{
            JSONObject pregunta = (JSONObject) preguntasJSON.get(tipo);

            String modo =  pregunta.get("modo").toString();
            String texto = (String) pregunta.get("texto");

            List<String> opciones = jsonArrToList((JSONArray) pregunta.get("opciones"));
            List<String> opcionesCorrectas = jsonArrToList((JSONArray) pregunta.get("opcionesCorrectas"));

            List<Opcion> opcionesConcretas;
            opcionesConcretas = crearListaOpciones(opciones, opcionesCorrectas);

            Pregunta nuevaPreg = fabrica.crearPregunta(texto, opcionesConcretas, tipo.toString(), modo);
            nuevasPreguntas.add(nuevaPreg);
        });
    }

    private void agregarPreguntasGroup(JSONArray preguntasGroupChoice, List<Pregunta> nuevasPreguntas) {
        FabricaDePreguntas fabrica = new FabricaDePreguntas();
        for (Object objetpPregunta : preguntasGroupChoice){
            JSONObject pregunta = (JSONObject) objetpPregunta;
            IModoDePregunta modo = (IModoDePregunta) pregunta.get("modo");
            String texto = (String) pregunta.get("texto");
//            FALTA OPCION DE GROUP
        }

    }

    private List<Opcion> crearListaOpciones(List<String> opciones, List<String> opcionesCorrectas) {
        List<Opcion> listaDeOp = new ArrayList<Opcion>();
        for(String opcion: opciones){
            Boolean esCorrecta = opcionesCorrectas.contains(opcion);
            Opcion nuevaOp = new Opcion(opcion, esCorrecta);
        }
        return listaDeOp;
    }

    private List<String> jsonArrToList(JSONArray jsonArray) {
        List<String> listaOp = new ArrayList<String>();
        if (jsonArray != null) {
            int len = jsonArray.size();
            for (int i = 0; i < len; i++){
                listaOp.add(jsonArray.get(i).toString());
            }
        }
        return listaOp;
    }
}
