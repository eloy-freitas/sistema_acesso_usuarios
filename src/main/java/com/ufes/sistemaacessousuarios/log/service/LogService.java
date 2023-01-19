package com.ufes.sistemaacessousuarios.log.service;

import com.ufes.sistemaacessousuarios.log.adapter.LogCSVAdapter;
import com.ufes.sistemaacessousuarios.model.Log;
import java.io.IOException;
import com.ufes.sistemaacessousuarios.log.adapter.ILogAdapter;


public class LogService {
    private ILogAdapter logAdapter;

    public LogService() throws IOException {
        logAdapter = new LogCSVAdapter("log/syslog.csv");
    }

    public void setLogAdapter(ILogAdapter logAdapter) {
        this.logAdapter = logAdapter;
    }
    
    public void escreverLog(Log log) throws IOException{
        logAdapter.writeLog(log);
    }
    
    
}
