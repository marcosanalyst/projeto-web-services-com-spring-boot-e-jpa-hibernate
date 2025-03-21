package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Order;

// os repositories são interfaces! Posso criar direto, ou indicar na descrição.
// @Repository não preciso colocar essa anotação, pois ela já era do JpaRepository
public interface OrderRepository extends JpaRepository<Order, Long>  {

}


