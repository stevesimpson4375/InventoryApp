package com;

import java.util.*;

public class Food extends Consumable{
    
    private String expireDate;
    
    public Food(String description, Double price, String purchaseDate,
            String expireDate, Double amount, String amountType){
        super(description, price, purchaseDate, amount, amountType);
        this.expireDate = expireDate;
    }

    public String getExipreDate() {
        return expireDate;
    }

    public void setExipreDate(String exipreDate) {
        this.expireDate = exipreDate;
    } 
}
