package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController // indica que é um controlador
@RequestMapping(value = "/users") // indica como chama meu recurso
public class UserResource {
		// método que é um end-point para acessar os usuários!
	
	// ResponseEntity retorna respostas de requisições web
	
	// o tipo da resposta vai ser a classe que eu definir, no caso <User>
	
	@GetMapping // método que responde o tipo GET do HTTP
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "João Meter", "joao.meter@gmail.com", "11 09999-0000", "123456"); {
		return ResponseEntity.ok().body(u);
		
		}
	}

}
