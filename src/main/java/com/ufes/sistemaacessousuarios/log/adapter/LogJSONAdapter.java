
package com.ufes.sistemaacessousuarios.log.adapter;

import com.ufes.sistemaacessousuarios.model.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class LogJSONAdapter implements ILogAdapter{
    private JSONObject fileJSON;
    private JSONParser parser;
    private FileWriter writer;
    private JSONArray jsonArray;
    
    public LogJSONAdapter(String nomeArquivo) throws FileNotFoundException, IOException, ParseException {
        if (!nomeArquivo.toLowerCase().endsWith("json")) {
            throw new FileNotFoundException("Informe um arquivo JSON válido");
        }
        parser = new JSONParser();
        Object obj = parser.parse(new FileReader(nomeArquivo));
        jsonArray = (JSONArray) obj;

    }
    @Override
    public void writeLog(Log log) throws IOException {
        JSONObject jSONObject = new JSONObject();
        
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        jSONObject.put("operacao", log.getOperacao());
        jSONObject.put("nome", log.getNome());
        jSONObject.put("data", log.getData().format(dataFormatter));
        jSONObject.put("hora", log.getHora().format(horaFormatter));
        jSONObject.put("usuario", log.getUsuario());
        jSONObject.put("mensagem", log.getMensagem());
        jsonArray.add(jSONObject);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();
    }
    
}
