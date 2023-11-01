  create table tarefa (
    tarefa_id int auto_increment primary key,
    tarefa_titulo varchar(100),
    tarefa_data_inicio date,
    tarefa_data_fim date,
    tarefa_feito boolean,
    usuario_id int not null,
    FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id)

  );
