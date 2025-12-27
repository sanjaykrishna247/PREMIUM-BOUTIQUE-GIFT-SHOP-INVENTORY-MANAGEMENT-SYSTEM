package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Warehouse;
import com.examly.springapp.repository.WarehouseRepo;

@Service
public class WarehouseServiceImpl implements WarehouseService{ 
    @Autowired 
    private WarehouseRepo warehouserepo;

    @Override
    public Warehouse AddWarehouse(Warehouse warehouse) { 
        return warehouserepo.save(warehouse);
   
    }

    @Override
    public List<Warehouse> GetAllWarehouse() { 
        return warehouserepo.findAll();
      
    }

    @Override
    public Warehouse GetWarehouseById(Long id) { 
        return warehouserepo.findById(id).orElse(null);
        
    }

    @Override
    public Warehouse UpdateWarehouse(Long id, Warehouse warehouse) { 
        Warehouse existing = warehouserepo.findById(id).orElse(null); 
        if(existing!=null)
        { 
            existing.setName(warehouse.getName()); 
            existing.setLocation(warehouse.getLocation()); 
            return warehouserepo.save(existing);
        } 
        return null;
    
    } 

    @Override 
    public List<Warehouse> GetWarehouseByLocation(String location)
    { 
        return warehouserepo.findWarehouseByLocation(location);
    }

    @Override
    public List<Warehouse> GetWarehouseByLocationAndName(String location, String name) { 
        return warehouserepo.GetWarehouseByLocationAndName(location, name);
    }
    
}
