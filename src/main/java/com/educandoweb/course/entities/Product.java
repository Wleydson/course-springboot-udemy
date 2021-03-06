package com.educandoweb.course.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.educandoweb.course.entities.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_product")
public class Product extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String description;
	
	private Double price;
	
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(name = "tb_product_category", 
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>(); 
	
	@OneToMany( mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();
	
	public Product() {
		super();
	}
	
	public Product(Long id,String name, String description, Double price, String imgUrl) {
		super();
		setId(id);
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}
	
	@JsonIgnore
	public Set<Order> getOrders(){
		Set<Order> set = new HashSet<>();
		for(OrderItem item : items) {
			set.add(item.getOrder());
		}
		return set;
	}
	
}
