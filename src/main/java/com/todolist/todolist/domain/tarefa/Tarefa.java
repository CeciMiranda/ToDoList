package com.todolist.todolist.domain.tarefa;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.todolist.todolist.domain.usuario.Usuario;
import com.todolist.todolist.enumerate.Prioridade;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity(name="tarefa")
@Table(name="tarefa")
@Data

public class Tarefa {

    @Id
    private Long id;

    @NotEmpty
    private String tarefa_titulo;

    @NotEmpty
    private LocalDateTime tarefa_data_inicio;
    
    @CreationTimestamp
    private LocalDateTime tarefa_data_fim;
    
    @CreationTimestamp
    private boolean tarefa_feito;

    private Prioridade prioridade;
    
    @NotEmpty

    @ManyToOne
    private Usuario usuario;

    
}
