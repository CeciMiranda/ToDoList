package com.todolist.todolist.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todolist.domain.usuario.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

@PostMapping("/")
    public void create( @RequestBody Usuario Usuario){
        System.out.println(Usuario.getNome());
    }
}
