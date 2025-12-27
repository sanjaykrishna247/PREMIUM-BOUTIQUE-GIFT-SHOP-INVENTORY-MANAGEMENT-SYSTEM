package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Category; 
import org.springframework.data.domain.*; 

public interface CategoryService {
    Category addCategory(Category category); 
    
    List<Category> getAllCategories(); 

    Category getCategoryById(Long id); 

    Category updateCategory(Long id,Category category);  

    public Page<Category> getCategoriesWithPagination(Pageable pageable); 

    
} 