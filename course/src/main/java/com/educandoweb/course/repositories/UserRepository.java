package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

// os repositories são interfaces! Posso criar direto, ou indicar na descrição.
public interface UserRepository extends JpaRepository<User, Long>  {

}

// vai instanciar um obj repository onde vai ter varias operações para trabalhar com o usuário!
