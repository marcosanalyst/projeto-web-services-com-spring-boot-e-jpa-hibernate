package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	// Lembrando para criar uma entidade
	// attributes // Basic attributes // assosciations
	// constructor // getters & setters // hashCode & equal (somente id) //
	// serializable

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-'T'HH:mm:ss'Z'", timezone = "GMT") // ISO 8601:
																											// isso vai
																											// garantir
																											// que meu
																											// BD
																											// trabalhe
																											// com esse
																											// formato.
	private Instant moment;

	// associations: relacionamento entre pedido e cliente (order e client)
	@ManyToOne // aqui devo ler os papeis no diagrama, o "*" muitos, está do lado do pedido
	@JoinColumn(name = "cliente_id") // nome do atributo da associação
	private User client;

	public Order() {

	}

	public Order(Long id, Instant moment, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

}
