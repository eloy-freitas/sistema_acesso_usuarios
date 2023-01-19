package com.ufes.sistemaacessousuarios;

import com.ufes.sistemaacessousuarios.log.service.LogService;
import com.ufes.sistemaacessousuarios.model.Log;
import com.ufes.sistemaacessousuarios.presenter.LoginPresenter;
import com.ufes.sistemaacessousuarios.presenter.PrincipalPresenter;
import com.ufes.sistemaacessousuarios.view.PrincipalView;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class SistemaAcessoUsuarios {
    public static void main(String[] args) throws IOException {
        //new PrincipalPresenter();
        LogService s = new LogService();
        s.escreverLog(new Log(
            "a", 
            "b",
            LocalDate.now(), 
            LocalTime.now(), 
            "c", 
            "d"
            )
        );
    }
}
