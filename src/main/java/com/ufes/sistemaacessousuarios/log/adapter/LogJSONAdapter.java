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
    private JSONArray jsonArray;
    private File file;
    
    public LogJSONAdapter(String nomeArquivo) throws FileNotFoundException, IOException {
        if (!nomeArquivo.toLowerCase().endsWith("json")) {
            throw new FileNotFoundException("Informe um arquivo JSON válido");
        }
        
        file = new File(nomeArquivo);

        try (FileReader reader = new FileReader(file))
        {
            //Read JSON file
             //JSON parser object to parse read file
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
 
            jsonArray = (JSONArray) obj;

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        } catch (ParseException e) {
            jsonArray = new JSONArray();
        }
    }
    
    @Override
    public void writeLog(Log log) throws IOException, FileNotFoundException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("operacao", log.getOperacao());
        jSONObject.put("nome", log.getNome());
        jSONObject.put("data", log.getData());
        jSONObject.put("hora", log.getHora());
        jSONObject.put("usuario", log.getUsuario());
        jSONObject.put("mensagem", log.getMensagem());
        jsonArray.add(jSONObject);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(jsonArray.toJSONString());
            writer.flush();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }
    
}
