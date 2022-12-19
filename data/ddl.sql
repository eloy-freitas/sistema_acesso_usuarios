create table usuario(
    id_usuario integer primary key autoincrement,
    nm_usuario varchar(100),
    nm_login varchar(30),
    ds_senha varchar(50),
    ds_email varchar(150),
    fl_admin boolean,
    fl_autorizado boolean,
    dt_cadastro date,
    dt_modificacao timestamp
);

create table notificacao(
    id_notificacao integer primary key autoincrement,
    id_remetente integer not null,
    ds_mensagem varchar(300),
    fl_lida boolean,
    dt_envio timestamp,
    FOREIGN KEY(id_remetente) REFERENCES usuario(id_usuario)
);

create table notificacao_usuarios(
    id_notificacao integer not null,
    id_destinatario integer not null,
    FOREIGN KEY(id_destinatario) REFERENCES usuario(id_usuario),
    FOREIGN KEY(id_notificacao) REFERENCES notificacao(id_notificacao)
);

