package com.demo.category.service;

import java.util.List;

import com.demo.category.entity.Category;

public interface CategoryService {

	public List<Category> findAll();
	
	public Category findById(int id);
	
	public Category create(Category category);
	
	public Category update(int id, Category category);
	
	public Category deleteById(int id);
	
}
