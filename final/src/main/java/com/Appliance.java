package com;

import com.googlecode.objectify.annotation.Subclass;
import com.googlecode.objectify.annotation.Index;

@Subclass(index=true)
public class Appliance extends Durable{

    static private String[] validTypes = { "Crock Pot", "Oven" ,"Refrigerator", "Toaster Oven" };
    
    public Appliance(String description, Double price, String purchaseDate,
        String material, Double weight){
        super(description, price, purchaseDate, material, weight);
    }
        
    static public String[] getValidTypes() {
        return validTypes;
    }
}
