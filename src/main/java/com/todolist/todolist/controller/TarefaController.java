package com.todolist.todolist.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.todolist.todolist.domain.tarefa.Tarefa;
import com.todolist.todolist.services.TarefaService;


@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired

    private TarefaService tarefaService;

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable Long id) {
        Tarefa obj = this.tarefaService.findById(id);
        return ResponseEntity.ok().body(obj);

    };

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Tarefa obj) {
    
        this.tarefaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Tarefa obj) {
        obj.setId(id);
        this.tarefaService.update(obj);
        return ResponseEntity.noContent().build();
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.tarefaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
