package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

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

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController // indica que é um controlador
@RequestMapping(value = "/users") // indica como chama meu recurso
public class UserResource {
    
    @Autowired
    private UserService service;

    @GetMapping // método que responde ao tipo GET do HTTP
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll(); 
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
    // inserir recurso devo usar @PostMapping
    
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
    	obj = service.insert(obj);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    	return ResponseEntity.created(uri).body(obj);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
    	service.delete(id);
    	return ResponseEntity.noContent().build(); // 204 resposta vazia
    } // Void porque a resposta da requisição, não vai retornar nenhum corpo (body vazio)
    
    // Método para atualizar o usuário! Atualizar um recurso.
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
    	obj = service.update(id, obj);
    	return ResponseEntity.ok().body(obj);
    }

    
}
