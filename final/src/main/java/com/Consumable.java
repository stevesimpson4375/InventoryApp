package com;

import com.googlecode.objectify.annotation.Subclass;
import com.googlecode.objectify.annotation.Index;

@Subclass(index=true)
public class Consumable extends InventoryItem{
    
    @Index private Double amount;
    @Index private String amountType;
    
    public Consumable(String description, Double price, String purchaseDate,
            Double amount, String amountType){
        super(description, price, purchaseDate);
        this.amount = amount;
        this.amountType = amountType;
    }
    
    public Consumable(){}

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }
}
