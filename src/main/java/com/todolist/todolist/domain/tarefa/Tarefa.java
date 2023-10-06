package com.todolist.todolist.domain.tarefa;

import java.util.Date;

import com.todolist.todolist.domain.usuario.Usuario;


public class Tarefa {
    private Long id;
    private String titulo;
    private Date prazo;
    private Usuario usuario;


    public Tarefa() {
    }

    public Tarefa(Long id, String titulo, Date prazo, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.prazo = prazo;
        this.usuario = usuario;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getPrazo() {
        return this.prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}


