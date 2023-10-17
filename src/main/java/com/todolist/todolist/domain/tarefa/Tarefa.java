package com.todolist.todolist.domain.tarefa;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name="tarefa")
@Table(name="tarefa")
@Data

public class Tarefa {

    @Id
    private Long id;

    @NotBlank
    private String tarefa_titulo;

    @NotBlank
    private LocalDateTime tarefa_prazo;

    private boolean tarefa_feito;
    
    @NotBlank
    private Long id_usuario;
}
