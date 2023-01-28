
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
    id_notificacao timestamp primary key, 
    fl_tipo int not null,
    ds_mensagem varchar(300)
);

create table usuarios_notificados(
    id_notificacao timestamp not null,
    id_destinatario integer not null,
    id_remetente integer not null,
    fl_lida boolean default 0,
    dt_visualizacao timestamp,
    dt_envio timestamp,
    FOREIGN KEY(id_destinatario) REFERENCES usuario(id_usuario),
    FOREIGN KEY(id_remetente) REFERENCES usuario(id_usuario),
    FOREIGN KEY(id_notificacao) REFERENCES notificacao(id_notificacao)
);
