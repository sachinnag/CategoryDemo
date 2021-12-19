package com.demo.category.service;

import java.util.List;
import com.demo.category.entity.SubCategory;

public interface SubCategoryService {

	public List<SubCategory> findAll();
	
	public SubCategory findById(int id);
	
	public SubCategory create(int id, SubCategory subCategory);
	
	public SubCategory update(int id, SubCategory subCategory);
	
	public SubCategory deleteById(int id);
	
}
