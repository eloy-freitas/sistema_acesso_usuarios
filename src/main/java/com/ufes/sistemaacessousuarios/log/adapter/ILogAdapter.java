
package com.ufes.sistemaacessousuarios.log.adapter;

import com.ufes.sistemaacessousuarios.model.Log;
import java.io.IOException;


public interface ILogAdapter {
    void writeLog(Log log) throws IOException;
}
