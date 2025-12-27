package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Product; 

public interface ProductService {

    Product AddProduct(Product product); 
    List<Product> GetAllProduct();  
    Product GetProductById(Long id);
    Product UpdateProduct(Long id,Product product); 
    List<Product> GetProductsBycategoryName(String name); 
    List<Product> GetProductByName(String name);
    
}


