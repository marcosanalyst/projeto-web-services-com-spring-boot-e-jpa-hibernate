package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration // mostra que é uma classe de configuração
@Profile("test") // para determinado perfil!! Igual ao que defini no application-test properties
public class TestConfig implements CommandLineRunner {
	
	@Autowired // associa a instância do UserRepository no TestConfig 
	private UserRepository userRepository; // userRepository é o objeto que acessa os dados!!

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		// chamo o userRepository para acessar os dados!!
		
		userRepository.saveAll(Arrays.asList(u1,u2)); // chamo o método .savelAll para salvar minha instanciação acima!
	}

}

// database seeding para popular o BD 

// CommandLineRunner (interface)