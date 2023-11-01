package com.todolist.todolist.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.todolist.todolist.domain.usuario.Usuario;
import com.todolist.todolist.services.UsuarioService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/usuarios")
@Validated
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario obj = this.usuarioService.findById(id);
        return ResponseEntity.ok().body(obj);

    };

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Usuario obj) {
        this.usuarioService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    };

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Usuario obj) {
        obj.setId(id);
        this.usuarioService.update(obj);
        return ResponseEntity.noContent().build();
    };


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
