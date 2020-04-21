package com.educandoweb.course.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.educandoweb.course.entities.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_payment")
public class Payment extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private Instant moment;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Order order;

	public Payment() {
		super();
	}

	public Payment(Long id, Instant moment, Order order) {
		super();
		setId(id);
		this.moment = moment;
		this.order = order;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
