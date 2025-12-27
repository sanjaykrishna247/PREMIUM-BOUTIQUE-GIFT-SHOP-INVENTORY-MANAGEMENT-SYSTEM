package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{  
    @Autowired 
    private CategoryRepo categoryRepo; 

    @Override  
    public Category addCategory(Category category)
    { 
        return categoryRepo.save(category);
    } 

    @Override 
    public List<Category> getAllCategories()
    { 
        return categoryRepo.findAll();
    }   

    @Override 
    public Category getCategoryById(Long id)
    { 
        return categoryRepo.findById(id).orElse(null);  
    } 

    @Override 
    public Category updateCategory (Long id,Category category)
    { 
        Category exsisting = categoryRepo.findById(id).orElse(null); 
        if(exsisting != null)
        {
            exsisting.setCategoryName(category.getCategoryName());  
            return categoryRepo.save(exsisting); 

        }  
        return null;
    } 

    @Override 
    public Page<Category> getCategoriesWithPagination(Pageable pageable)
    { 
        return categoryRepo.findAll(pageable);
    } 

        
    
}
