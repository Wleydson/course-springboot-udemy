package com.educandoweb.course.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.educandoweb.course.entities.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_category")
public class Category extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "categories")
	private Set<Product> products = new HashSet<>();
	
	public Category() {
		super();
	}
	
	public Category(Long id, String name) {
		super();
		setId(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}
	
	

}
