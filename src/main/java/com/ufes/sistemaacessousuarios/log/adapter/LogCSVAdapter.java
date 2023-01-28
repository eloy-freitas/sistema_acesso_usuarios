package com.ufes.sistemaacessousuarios.log.adapter;

import com.opencsv.CSVWriter;
import com.ufes.sistemaacessousuarios.model.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LogCSVAdapter implements ILogAdapter{
    private FileWriter writer;
    private CSVWriter csvWriter;
    private File arquivo;
    public LogCSVAdapter(String nomeArquivo) throws FileNotFoundException, IOException {
        if (!nomeArquivo.toLowerCase().endsWith("csv")) {
            throw new FileNotFoundException("Informe um arquivo CSV válido");
        }
        arquivo = new File(nomeArquivo);
        this.writer = new FileWriter(arquivo,true);
        this.csvWriter = new CSVWriter(
            writer, 
            ';', 
            CSVWriter.DEFAULT_QUOTE_CHARACTER, 
            CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
            CSVWriter.DEFAULT_LINE_END
        );
    }

    @Override
    public void writeLog(Log log) throws IOException{
        List<String[]> data = new ArrayList<>();
        data.add(
            new String[] {
                log.getOperacao(), 
                log.getNome(),
                log.getData(),
                log.getHora(),
                log.getUsuario(), 
                log.getMensagem()
            }
        );
        csvWriter.writeAll(data);
        csvWriter.close();
    }
}
