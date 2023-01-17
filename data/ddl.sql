create table usuario(
	id_usuario integer primary key autoincrement,
    nm_usuario varchar(100),
    nm_username varchar(30) unique,
    ds_senha varchar(50),
    ds_email varchar(150),
    fl_admin boolean default 0,
    fl_autorizado boolean default 0,
    fl_ativo boolean default 1,
    dt_cadastro date,
    dt_modificacao timestamp
);

create table notificacao(
    id_notificacao integer primary key autoincrement,
    ds_mensagem varchar(300),
    dt_envio timestamp
);

create table usuarios_notificados(
    id_notificacao integer not null,
    id_destinatario integer not null,
    id_remetente integer not null,
    fl_lida boolean default 0,
    df_leitura timestamp,
    FOREIGN KEY(id_destinatario) REFERENCES usuario(id_usuario),
    FOREIGN KEY(id_remetente) REFERENCES usuario(id_usuario),
    FOREIGN KEY(id_notificacao) REFERENCES notificacao(id_notificacao)
);
