package com.ufes.sistemaacessousuarios.validadorsenha;

import com.pss.senha.validacao.ValidadorSenha;
import java.io.IOException;
import java.util.List;


public class ValidadorSenhaUfes implements IValidadorSenhaAdapter{

    @Override
    public void validar(String senha) throws IOException {
        if(senha.isBlank())
            throw new IOException("Campo de senha não pode ser vazio");
        
        List<String> resultado = new ValidadorSenha().validar(senha);
        
        if(resultado.size() > 0)
            throw new IOException(String.join("\n", resultado));
        
    }
    
}
