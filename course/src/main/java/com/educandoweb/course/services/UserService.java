package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//@Component // registra a classe como componente no spring, para ser injetado automaticamente com autowired

@Service // essa é uma classe de serviço
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll(); // atualizar o UserResource
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get() ;
	}
	
	// operação básica para inserir um novo usuário no BD
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	
	// Primeiro crio um método simples para deletar, depois vou 
	// UserResource, incluo o end-point para deletar!
	public void delete(Long id) {
		repository.deleteById(id);
	}
}

// operação buscar todos os usuários e buscar por todos os ids
