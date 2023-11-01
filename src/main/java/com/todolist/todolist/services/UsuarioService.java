package com.todolist.todolist.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.todolist.domain.usuario.Usuario;
import com.todolist.todolist.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    

    public Usuario findById(Long id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new RuntimeException(
            "Usuário não encontrado! Id: " + id + ", Tipo:" + Usuario.class.getName()
        ));
    }

    @Transactional
    public Usuario create(Usuario obj) {
        obj.setId(null);
        obj = this.usuarioRepository.save(obj);
        return obj;
    }

    @Transactional
    public Usuario update(Usuario obj) {
        Usuario newObj = findById(obj.getId());
        newObj.setSenha(obj.getSenha());
        return this.usuarioRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir  pois há tarefas relacionadas!");
        }
    }

}
