package com;

import java.util.*;
import com.googlecode.objectify.annotation.Subclass;
import com.googlecode.objectify.annotation.Index;
import java.text.*;

@Subclass(index=true)
public class Food extends Consumable{
    
    @Index private String expireDate;
    
    private static String[] fields = { "Description", "Price", "Purchase Date",
        "Expire Date", "Amount", "Amount Type"};
    
    public Food(String description, Double price, String purchaseDate,
            String expireDate, Double amount, String amountType){
        super(description, price, purchaseDate, amount, amountType);
        this.expireDate = expireDate;
    }
    
    public Food(){}

    public static String[] getFields() {
        return fields;
    }
    
    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String exipreDate) {
        this.expireDate = exipreDate;
    }
    
    @Override
    public String toString() {
        return "This is: " + getDescription() + " and it expires " + getExpireDate();
    }
}