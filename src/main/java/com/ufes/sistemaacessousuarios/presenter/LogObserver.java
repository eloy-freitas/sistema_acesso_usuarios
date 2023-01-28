package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.model.Log;


public interface LogObserver {
    void escreverLog(Log log);
}
