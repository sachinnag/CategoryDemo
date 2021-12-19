package com.demo.category.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
	private List<SubCategory> subCategories;
	
	public Category() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<SubCategory> getSubCategories() {
		return subCategories;
	}
	
	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
		
		for(SubCategory subCategory : subCategories) {
			subCategory.setCategory(this);
		}
	}
	
}
