package com.educandoweb.course.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.educandoweb.course.entities.base.BaseEntity;

@Entity
@Table(name = "tb_category")
public class Category extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String name;
	
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

}
