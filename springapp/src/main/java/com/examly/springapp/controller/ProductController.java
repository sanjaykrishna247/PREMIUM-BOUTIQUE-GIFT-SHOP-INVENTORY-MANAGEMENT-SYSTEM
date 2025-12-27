package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;

@RestController
@RequestMapping("/api/products") 
public class ProductController {   

    @Autowired 
    private ProductService productService;

    @PostMapping 
    ResponseEntity<Product> AddProduct(@RequestBody Product product)
    { 
        return new ResponseEntity<>(productService.AddProduct(product),HttpStatus.CREATED);
    } 

    @GetMapping("/{id}") 
    ResponseEntity<Product> GetProductById(@PathVariable Long id){ 
        
        return ResponseEntity.ok(productService.GetProductById(id));
    }   

    @GetMapping 
    ResponseEntity<List<Product>> GetAllProduct()
    { 
        return ResponseEntity.ok(productService.GetAllProduct());
    } 

    @PutMapping("/{id}")
    ResponseEntity<Product> UpdateProduct(@PathVariable Long id,@RequestBody Product product){ 
        return ResponseEntity.ok(productService.UpdateProduct(id,product));
    }
    @GetMapping("/category/{name}")
    ResponseEntity<List<Product>> GetProductsBycategoryName(@PathVariable String name)
    { 
        return ResponseEntity.ok(productService.GetProductsBycategoryName(name));
    } 

    @GetMapping("/name/{name}") 
    ResponseEntity<?> GetProductByName(@PathVariable String name) 
    {  
        List<Product> p = productService.GetProductByName(name); 
        if(p.isEmpty())
        { 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found with name: " + name);
        }
        return ResponseEntity.ok(p);
    }

    
}
