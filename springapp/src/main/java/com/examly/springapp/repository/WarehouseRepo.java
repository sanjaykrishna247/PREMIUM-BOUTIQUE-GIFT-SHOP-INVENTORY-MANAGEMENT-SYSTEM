package com.examly.springapp.repository;  
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Warehouse; 



@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse,Long>{
@Query("Select w From Warehouse w where w.location = :location")
List<Warehouse> findWarehouseByLocation(@Param("location")String location);
@Query("Select w From Warehouse w where w.location = :location and w.name = :name")
List<Warehouse> GetWarehouseByLocationAndName(@Param("location")String location,@Param("name") String name);
    
} 