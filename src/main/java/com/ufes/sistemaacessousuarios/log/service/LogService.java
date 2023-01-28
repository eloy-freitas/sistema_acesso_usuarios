package com.ufes.sistemaacessousuarios.log.service;

import com.ufes.sistemaacessousuarios.log.adapter.LogCSVAdapter;
import com.ufes.sistemaacessousuarios.model.Log;
import java.io.IOException;
import com.ufes.sistemaacessousuarios.log.adapter.ILogAdapter;
import com.ufes.sistemaacessousuarios.log.adapter.LogJSONAdapter;


public class LogService {
    private ILogAdapter logAdapter;
    private String file;

    public LogService() throws IOException {
        file = "log/syslog.csv";
        logAdapter = new LogCSVAdapter(file);
    }
    
    public void setLogAdapter(ILogAdapter logAdapter) {
        this.logAdapter = logAdapter;
    }
    
    public void setJSONLogger() throws IOException{
        file = "log/syslog.json";
        this.logAdapter = new LogJSONAdapter(file);
    }
    
    public void setCSVLogger() throws IOException{
        file =  "log/syslog.csv";
        this.logAdapter = new LogCSVAdapter(file);
    }
    
    public void escreverLog(Log log) throws IOException{
        logAdapter.writeLog(log);
    }

    public String getFile() {
        return file;
    }
    
    
    
}
