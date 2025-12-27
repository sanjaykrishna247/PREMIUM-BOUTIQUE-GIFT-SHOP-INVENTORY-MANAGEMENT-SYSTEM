package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class StockEntry { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long stockEntryId; 
    private Integer quantity; 

    @ManyToOne 
    @JoinColumn(name = "product_id") 
    private Product product;  

    @ManyToOne 
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse; 

    public StockEntry(){} 

    public Long getstockEntryId() 
    { 
        return stockEntryId;
    } 

    public void setstockEntryId(Long stockEntryId)
    { 
        this.stockEntryId = stockEntryId;
    }  
    
    public Integer getquantity() 
    { 
        return quantity;
    } 

    public void setquantity(Integer quantity)
    { 
        this.quantity = quantity;
    }  



    
}
