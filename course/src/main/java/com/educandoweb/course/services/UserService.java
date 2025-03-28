package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.execeptions.DatabaseException;
import com.educandoweb.course.services.execeptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	// operação básica para inserir um novo usuário no BD
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	
	// Primeiro crio um método simples para deletar, depois vou 
	// UserResource, incluo o end-point para deletar!
	public void delete(Long id) {
	    try {
	        if(!repository.existsById(id)) throw new ResourceNotFoundException(id);
	        repository.deleteById(id);
	    }catch (ResourceNotFoundException e){
	        throw new ResourceNotFoundException(id);
	    }catch (DataIntegrityViolationException e) {
	    	throw new DatabaseException(e.getMessage());
	    }
	}
	
	public User update(Long id, User obj) {
		try {
		User entity = repository.getReferenceById(id); // antigo getOne
		updateData(entity, obj); // atualizar o entity baseado nos dados que chegaram do obj!!
		return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
		

	private void updateData(User entity, User obj) {
		// TODO Auto-generated method stub
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}

// operação buscar todos os usuários e buscar por todos os ids
