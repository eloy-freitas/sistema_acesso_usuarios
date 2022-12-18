create table usuario(
    id_usuario integer primary key autoincrement,
    nm_usuario varchar(100),
    ds_senha varchar(50),
    ds_email varchar(150),
    dt_modificacao datetime
);
