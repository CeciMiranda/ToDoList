package com.todolist.todolist.domain.usuario;

import java.util.ArrayList;
import java.util.List;

import com.todolist.todolist.domain.tarefa.Tarefa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="usuario")
@Table(name="usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")

public class Usuario {

    @Id
    public Long id;

    @NotBlank
    @Size(min=5,max=100)
    public String nome;

    @NotBlank
    @Size(min=5,max=100)
    public String senha;

    private List<Tarefa> tarefas = new ArrayList<Tarefa>();
}


