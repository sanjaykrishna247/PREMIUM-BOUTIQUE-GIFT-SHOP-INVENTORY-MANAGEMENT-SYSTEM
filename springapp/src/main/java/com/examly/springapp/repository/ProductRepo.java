package com.examly.springapp.repository; 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Product; 



@Repository 

public interface ProductRepo extends JpaRepository<Product,Long>{  

    @Query("Select p from Product p where p.category.categoryName  = :name")
    List<Product> GetProductsBycategoryName(@Param("name") String name); 
    
    @Query("Select p from Product p where p.productName = :name") 
    List<Product> GetProductByName(@Param("name") String name);
} 