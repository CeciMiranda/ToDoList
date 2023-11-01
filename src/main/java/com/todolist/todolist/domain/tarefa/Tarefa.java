package com.todolist.todolist.domain.tarefa;

import java.time.LocalDate;

import com.todolist.todolist.domain.usuario.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity(name="tarefa")
@Table(name="tarefa")
@Data

public class Tarefa {

    @Id
    @Column(name="tarefa_id")
    private Long id;

    @NotEmpty
    @Column(name="tarefa_titulo")
    private String tarefa_titulo;

    @NotEmpty
    @Column(name="tarefa_data_inicio")
    private LocalDate tarefa_data_inicio;
    
    @Column(name="tarefa_data_fim")
    private LocalDate tarefa_data_fim;
    
    @Column(name="tarefa_feito")
    private boolean tarefa_feito;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "usuario_id")
    private Usuario usuario;
}
