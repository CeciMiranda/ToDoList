package com.todolist.todolist.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.todolist.todolist.domain.tarefa.Tarefa;
import com.todolist.todolist.domain.usuario.Usuario;
import com.todolist.todolist.repository.TarefaRepository;

import jakarta.transaction.Transactional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioService usuarioService;


    public Tarefa findById(Long id) {
        Optional<Tarefa> tarefa = this.tarefaRepository.findById(id);
        return tarefa.orElseThrow(() -> new RuntimeException(
            "Tarefa não encontrada! Id:" + id + ", Tipo" + Tarefa.class.getName()
        ));
    }

    @Transactional
    public Tarefa create(Tarefa obj) {
        
        Usuario usuario = this.usuarioService.findById(obj.getUsuario().getId());
        
        obj.setUsuario(usuario);
        obj = this.tarefaRepository.save(obj);
        return obj;
    }


    

    

    @Transactional
    public Tarefa update (Tarefa obj) {
        Tarefa newObj = findById(obj.getId());
        newObj.setTarefa_titulo(obj.getTarefa_titulo());
        return this.tarefaRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.tarefaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há usuarios relacionados!");
        }
    }
}
