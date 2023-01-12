package com.ufes.sistemaacessousuarios.presenter;

import com.ufes.sistemaacessousuarios.model.Usuario;


public interface LoginObserver {
    void updateLogin(Usuario usuario);
}
