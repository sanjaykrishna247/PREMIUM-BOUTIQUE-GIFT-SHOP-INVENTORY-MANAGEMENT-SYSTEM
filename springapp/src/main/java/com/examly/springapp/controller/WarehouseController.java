package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Warehouse;
import com.examly.springapp.service.WarehouseService;

@RestController 
@RequestMapping("/api/warehouses")
public class WarehouseController {   
    @Autowired 
    private WarehouseService warehouseService;
    @GetMapping("/{id}")
    ResponseEntity<Warehouse>GetWarehouseById(@PathVariable Long id)
    { 
        return ResponseEntity.ok(warehouseService.GetWarehouseById(id));
    } 

    @GetMapping 
    ResponseEntity<List<Warehouse>>GetAllWarehouse(){ 
        return ResponseEntity.ok(warehouseService.GetAllWarehouse()); 
    } 

    @PostMapping
    ResponseEntity<Warehouse> AddWarehouse(@RequestBody Warehouse warehouse)
    { 
        return new ResponseEntity<>(warehouseService.AddWarehouse(warehouse),HttpStatus.CREATED); 
    } 

    @PutMapping("/{id}")
    ResponseEntity<Warehouse> UpdateWarehouse(@PathVariable Long id,@RequestBody Warehouse warehouse)
    { 
        return ResponseEntity.ok(warehouseService.UpdateWarehouse(id, warehouse));
    } 

    @GetMapping("/location/{location}") 
    ResponseEntity<?> GetWarehouseByLocation(@PathVariable String location) 
    { 
        List<Warehouse> w = warehouseService.GetWarehouseByLocation(location); 
        if(w.isEmpty())
        { 
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No warehouses found at location: " + location);
        }  

        return ResponseEntity.ok(w);
    } 

    @GetMapping("/location/{location}/name/{name}") 
    ResponseEntity<List<Warehouse>>GetWarehouseByLocationAndName(@PathVariable String location,@PathVariable String name)
    { 
        return ResponseEntity.ok(warehouseService.GetWarehouseByLocationAndName(location, name));
    }
}
