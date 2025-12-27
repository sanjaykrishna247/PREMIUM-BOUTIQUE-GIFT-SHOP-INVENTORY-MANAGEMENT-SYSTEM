package com.examly.springapp.controller;

import java.util.HashMap;
import java.util.Map; 
import java.util.List;  
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; 
import org.springframework.data.domain.*;

import com.examly.springapp.model.Category;
import com.examly.springapp.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {   
    @Autowired 
    private CategoryService categoryService; 

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){ 
        
            Category saved = categoryService.addCategory(category);
            return new ResponseEntity<>(saved,HttpStatus.CREATED);
        
    } 

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){  
        List<Category> categories = categoryService.getAllCategories(); 
        if(categories.isEmpty()){ 
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);  
    }  


    @GetMapping("/{id:\\d+}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){ 
        return ResponseEntity.ok(categoryService.getCategoryById(id));  
    }  
    
    @PutMapping("/{id}")
    public ResponseEntity<Category> UpdateCategory(@PathVariable Long id,@RequestBody Category category){ 
        return ResponseEntity.ok(categoryService.updateCategory(id,category)); 
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){ 
        return ResponseEntity.noContent().build(); 
    }
    


    @GetMapping("/page/{pageNumber}/{pageSize}") 
    public ResponseEntity<Map<String,Object>> getCategoriesWithPagination( 
        @PathVariable int pageNumber,
        @PathVariable int pageSize
    ){
        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize,Sort.by("categoryId").ascending()); 
        Page<Category> page =  categoryService.getCategoriesWithPagination(pageRequest);   

        Map<String,Object> sort = new HashMap<>(); 
        sort.put("sorted",page.getSort().isSorted()); 
        
        Map<String,Object> pageableMap = new HashMap<>(); 
        pageableMap.put("pageNumber", page.getNumber()); 
        pageableMap.put("pageSize", page.getSize()); 
        pageableMap.put("sort", sort);
        
        
        Map<String,Object> response = new HashMap<>(); 
        response.put("content", page.getContent()); 
        response.put("pageable", pageableMap);    
        response.put("totalElements", page.getTotalElements()); 
        response.put("totalPages",page.getTotalPages());  

        return ResponseEntity.ok(response);

    } 

}
