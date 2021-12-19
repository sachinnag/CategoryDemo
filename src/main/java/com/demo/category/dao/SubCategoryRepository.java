package com.demo.category.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.category.entity.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

}
