create table nivelImportancia (
  nivel_id int auto_increment primary key,
  nivel_nome varchar(100),
  tarefa_id int not null,
  FOREIGN KEY (tarefa_id) REFERENCES tarefa(tarefa_id)
);