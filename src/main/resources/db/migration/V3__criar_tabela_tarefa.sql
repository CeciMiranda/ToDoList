
ALTER TABLE tarefa
ADD COLUMN tarefa_data_inicio datetime,
ADD COLUMN tarefa_data_fim datetime;

ALTER TABLE tarefa
DROP COLUMN tarefa_prazo;
