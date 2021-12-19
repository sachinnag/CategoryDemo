package com.demo.category.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.category.dao.CategoryRepository;
import com.demo.category.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(int id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		
		return null;
	}

	@Override
	public Category create(Category category) {
		Category createdCategory = categoryRepository.save(category);
		return createdCategory;
	}
	
	@Override
	public Category update(int id, Category category) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		
		if(optionalCategory.isPresent()) {
			category.setId(id);
			Category updatedCategory = categoryRepository.save(category);
			//updatedCategory.setSubCategories(optionalCategory.get().getSubCategories());
			return updatedCategory;
		}
		
		return null;
	}

	@Override
	public Category deleteById(int id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		
		if(optionalCategory.isPresent()) {
			categoryRepository.delete(optionalCategory.get());
			return optionalCategory.get();
		}
		
		return null;
	}

}
