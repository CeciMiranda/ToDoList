package com.todolist.todolist.domain.usuario;

import java.util.List;

import com.todolist.todolist.domain.tarefa.Tarefa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @NotBlank
    @Size(min=5,max=100)
    @Column(name = "usuario_nome")
    private String nome;

    @NotBlank
    @Size(min=5,max=100)
    @Column(name = "usuario_senha")
    private String senha;
    
    @OneToMany(mappedBy = "usuario")
    private List<Tarefa> tarefas;
}


