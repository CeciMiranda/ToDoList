package com.todolist.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.todolist.domain.tarefa.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    
}
