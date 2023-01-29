package com.ufes.sistemaacessousuarios.validadorsenha;

import java.io.IOException;


public class ValidadorSenhaService {
    
    private IValidadorSenhaAdapter adapter;

    public ValidadorSenhaService() {
        adapter = new ValidadorSenhaUfes();
    }

    public ValidadorSenhaService(IValidadorSenhaAdapter adapter) {
        this.adapter = adapter;
    }

    public void setAdapter(IValidadorSenhaAdapter adapter) {
        this.adapter = adapter;
    }
    
    public void validar(String senha) throws IOException{
        adapter.validar(senha);
    }
}
