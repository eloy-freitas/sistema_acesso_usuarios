package com.ufes.sistemaacessousuarios.log.service;

import com.ufes.sistemaacessousuarios.log.adapter.LogCSVAdapter;
import com.ufes.sistemaacessousuarios.model.Log;
import java.io.IOException;
import com.ufes.sistemaacessousuarios.log.adapter.ILogAdapter;


public class LogService {
    private ILogAdapter logAdapter;
    private String file;
    public LogService() throws IOException {
        file = "log/syslog.csv";
        logAdapter = new LogCSVAdapter(file);
    }

    public void setFile(String file) {
        this.file = file;
    }
    
    public void setLogAdapter(ILogAdapter logAdapter) {
        this.logAdapter = logAdapter;
    }
    
    public void escreverLog(Log log) throws IOException{
        logAdapter.writeLog(log);
    }
    
    
}
