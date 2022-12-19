create table usuario(
    id_usuario integer primary key autoincrement,
    nm_usuario varchar(100),
    nm_login varchar(30) unique,
    ds_senha varchar(50),
    ds_email varchar(150),
    fl_admin boolean default 0,
    fl_autorizado boolean default 0,
    dt_cadastro date,
    dt_modificacao timestamp
);

create table notificacao(
    id_notificacao integer primary key autoincrement,
    id_remetente integer not null,
    id_tipo integer not null,
    ds_mensagem varchar(300),
    dt_envio timestamp,
    FOREIGN KEY(id_remetente) REFERENCES usuario(id_usuario),
    FOREIGN KEY(id_tipo) REFERENCES tipo_notificacao(id_tipo)
);

create table tipo_notificacao(
    id_tipo integer primary key autoincrement,
    ds_tipo varchar(100)
);

create table usuarios_notificados(
    id_notificacao integer not null,
    id_destinatario integer not null,
    fl_lida boolean default 0,
    df_leitura timestamp,
    FOREIGN KEY(id_destinatario) REFERENCES usuario(id_usuario),
    FOREIGN KEY(id_remetente) REFERENCES usuario(id_remetente),
    FOREIGN KEY(id_notificacao) REFERENCES notificacao(id_notificacao)
);
