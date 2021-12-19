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
import org.springframework.web.server.ResponseStatusException;

import com.demo.category.entity.Category;
import com.demo.category.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/categories")
	public ResponseEntity<?> getAllCategory() {
		
		List<Category> categories = categoryService.findAll();
		
		if(categories != null) {
			return ResponseEntity.ok(categories);
		}
		
		return new ResponseEntity<>("No Content", HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<?> getCategory(@PathVariable int id) {
		
		Category category = categoryService.findById(id);
		
		if(category != null) {
			return ResponseEntity.ok(category); 
		}
		
		return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/categories")
	public ResponseEntity<?> createCategory(@RequestBody Category category) {
		
		Category createCategory = categoryService.create(category);
		
		if(createCategory != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createCategory);
		}
		
		return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody Category category) {
		
		Category createdCategory = categoryService.update(id, category);
		
		if(createdCategory != null) {
			return ResponseEntity.ok(createdCategory);
		}
		
		return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable int id) {
		
		Category createCategory = categoryService.deleteById(id);
		
		if(createCategory != null) {
			return ResponseEntity.ok(createCategory);
		}
		
		return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
		
	}
	
}
