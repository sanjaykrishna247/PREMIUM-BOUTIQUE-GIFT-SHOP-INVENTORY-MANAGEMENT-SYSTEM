package com.examly.springapp.model;
import jakarta.persistence.*; 



@Entity
public class StockMovement { 

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 

    private Long movementId; 
    private Integer quantity; 
    private String movement; 

    @ManyToOne 
    @JoinColumn(name = "product_id") 
    private Product product; 

    @ManyToOne
    @JoinColumn(name = "warehouse_id") 
    private Warehouse warehouse; 

    public Long getmovementId()
    { 
        return movementId;
    } 

    public void setmovementId(Long movementId) 
    { 
        this.movementId = movementId;
    }

    public Integer getquantity()
    { 
        return quantity;
    } 

    public void setquantity(Integer quantity) 
    { 
        this.quantity = quantity; 
    }
    public String getmovement()
    { 
        return movement;
    } 

    public void setmovement(String movement) 
    { 
        this.movement = movement; 
    }
    

}
