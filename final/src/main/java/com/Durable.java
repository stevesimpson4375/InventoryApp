package com;

import com.googlecode.objectify.annotation.Subclass;
import com.googlecode.objectify.annotation.Index;
import java.util.Date;

@Subclass(index=true)
public class Durable extends InventoryItem{
    
    @Index private String material;
    @Index private Double weight;

    public Durable(String description, Double price, Date purchaseDate,
        String material, Double weight){
        super(description, price, purchaseDate);
        this.material = material;
        this.weight = weight;
    }
    
    public Durable(){}
    
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }    
}
