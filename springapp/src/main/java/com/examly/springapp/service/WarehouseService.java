package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Warehouse;

public interface WarehouseService {  

    Warehouse AddWarehouse(Warehouse warehouse); 
    List<Warehouse> GetAllWarehouse();  
    Warehouse GetWarehouseById(Long id); 
    Warehouse UpdateWarehouse(Long id,Warehouse warehouse); 
    List<Warehouse> GetWarehouseByLocation(String location); 
    List<Warehouse> GetWarehouseByLocationAndName(String location ,String name);
    
}
