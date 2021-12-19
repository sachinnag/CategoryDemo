package com.demo.category.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
