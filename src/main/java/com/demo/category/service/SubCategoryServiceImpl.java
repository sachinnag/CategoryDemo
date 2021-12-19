package com.demo.category.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.category.dao.CategoryRepository;
import com.demo.category.dao.SubCategoryRepository;
import com.demo.category.entity.Category;
import com.demo.category.entity.SubCategory;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	private CategoryRepository categoryRepository;
	private SubCategoryRepository subCategoryRepository;
	
	@Autowired
	public SubCategoryServiceImpl(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository) {
		this.categoryRepository = categoryRepository;
		this.subCategoryRepository = subCategoryRepository;
	}
	
	@Override
	public List<SubCategory> findAll() {
		return subCategoryRepository.findAll();
	}

	@Override
	public SubCategory findById(int id) {
		Optional<SubCategory> optionalSubCategory = subCategoryRepository.findById(id);
		
		if(optionalSubCategory.isPresent()) {
			return optionalSubCategory.get();
		}
		
		return null;
	}

	@Override
	public SubCategory create(int id, SubCategory subCategory) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		
		if(optionalCategory.isPresent()) {
			
			subCategory.setCategory(optionalCategory.get());
			
			SubCategory createdSubCategory = subCategoryRepository.save(subCategory);
			
			return createdSubCategory;
		}
		
		return null;
	}
	
	@Override
	public SubCategory update(int id, SubCategory subCategory) {
		Optional<SubCategory> optionalSubCategory = subCategoryRepository.findById(id);

		if(optionalSubCategory.isPresent()) {
			
			subCategory.setId(optionalSubCategory.get().getId());
			subCategory.setCategory(optionalSubCategory.get().getCategory());
			
			SubCategory updatedSubCategory = subCategoryRepository.save(subCategory);
			
			return updatedSubCategory;
		}
		
		
		return null;
	}

	@Override
	public SubCategory deleteById(int id) {
		Optional<SubCategory> optionalSubCategory = subCategoryRepository.findById(id);
		
		if(optionalSubCategory.isPresent()) {
			subCategoryRepository.delete(optionalSubCategory.get());
			return optionalSubCategory.get();
		}
		
		return null;
	}

}
