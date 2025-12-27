package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{ 

    @Autowired 
    private ProductRepo productRepo;     
    
    @Override 
    public Product AddProduct(Product product)
    {  
        return productRepo.save(product);
    }

    @Override
    public List<Product> GetAllProduct() 
    {
        return productRepo.findAll();
    }

    @Override
    public Product GetProductById(Long id) {

        return productRepo.findById(id).orElse(null);
        
    }

    @Override
    public Product UpdateProduct(Long id, Product product) { 

        Product existing = productRepo.findById(id).orElse(null); 

        if(existing!=null)
        { 
            existing.setProductName(product.getProductName()); 
            existing.setDescription(product.getDescription()); 
            existing.setCategory(product.getCategory());  
            return productRepo.save(existing);

        } 

        return null;
       
    }  

    @Override 

    public List<Product> GetProductsBycategoryName(String name)
    { 
        return productRepo.GetProductsBycategoryName(name);
    }

    @Override
    public List<Product> GetProductByName(String name) {
        return productRepo.GetProductByName(name);
    }







    
      


}
