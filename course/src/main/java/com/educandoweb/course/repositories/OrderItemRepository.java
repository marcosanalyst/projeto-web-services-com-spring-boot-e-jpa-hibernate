package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.entities.pk.OrderItemPK;


// os repositories são interfaces! Posso criar direto, ou indicar na descrição.
// @Repository não preciso colocar essa anotação, pois ela já era do JpaRepository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK >  {

}

// vai instanciar um obj repository onde vai ter varias operações para trabalhar com o usuário!
