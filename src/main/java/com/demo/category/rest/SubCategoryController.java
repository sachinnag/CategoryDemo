package com.demo.category.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.category.entity.SubCategory;
import com.demo.category.service.SubCategoryService;

@RestController
@RequestMapping("/api")
public class SubCategoryController {

	private SubCategoryService subCategoryService;
	
	@Autowired
	public SubCategoryController(SubCategoryService subCategoryService) {
		this.subCategoryService = subCategoryService;
	}
	
	@GetMapping("/categories/subcategories")
	public ResponseEntity<?> getAllCategory() {
		
		List<SubCategory> subCategories = subCategoryService.findAll();
		
		if(subCategories != null) {
			return ResponseEntity.ok(subCategories);
		}
		
		return new ResponseEntity<>("No Content", HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping("/categories/subcategories/{id}")
	public ResponseEntity<?> getCategory(@PathVariable int id) {
		
		SubCategory category = subCategoryService.findById(id);
		
		if(category != null) {
			return ResponseEntity.ok(category); 
		}
		
		return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/categories/{id}/subcategories")
	public ResponseEntity<?> createCategory(@PathVariable int id, @RequestBody SubCategory category) {
		
		SubCategory createdSubCategory = subCategoryService.create(id, category);
		
		if(createdSubCategory != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdSubCategory);
		}
		
		return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@PutMapping("/categories/subcategories/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody SubCategory category) {
		
		SubCategory updatedSubCategory = subCategoryService.update(id, category);
		
		if(updatedSubCategory != null) {
			return ResponseEntity.ok(updatedSubCategory);
		}
		
		return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/categories/subcategories/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable int id) {
		
		SubCategory deletedSubCategory = subCategoryService.deleteById(id);
		
		if(deletedSubCategory != null) {
			return ResponseEntity.ok(deletedSubCategory);
		}
		
		return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
		
	}
	
}
