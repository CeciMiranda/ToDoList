create table tarefa (
  tarefa_id int auto_increment primary key,
  tarefa_titulo varchar(100),
  tarefa_prazo datetime,
  tarefa_feito boolean,
  tarefa_prioridade varchar(50),
  usuario_id int not null,
  FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id)

);
