package com;

import java.util.*;
import com.googlecode.objectify.annotation.Subclass;
import com.googlecode.objectify.annotation.Index;

@Subclass(index=true)
public class Food extends Consumable{
    
    @Index private String expireDate;
    
    public Food(String description, Double price, String purchaseDate,
            String expireDate, Double amount, String amountType){
        super(description, price, purchaseDate, amount, amountType);
        this.expireDate = expireDate;
    }
    
    public Food(){}

    public String getExipreDate() {
        return expireDate;
    }

    public void setExipreDate(String exipreDate) {
        this.expireDate = exipreDate;
    }
}
