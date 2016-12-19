package com;

import com.googlecode.objectify.annotation.Subclass;
import com.googlecode.objectify.annotation.Index;
import java.util.Date;

@Subclass(index=true)
public class Appliance extends Durable{

    static private String[] validTypes = { "Bread Machine", "Crock Pot", "Oven" ,
        "Refrigerator", "Toaster Oven" };
    
    static private String[] fields = { "Description", "Price", "Purchase Date",
        "Material", "Weight (in kg)"};
    
    private String type;
    
    public Appliance(String description, Double price, Date purchaseDate,
        String material, Double weight, String type){
        super(description, price, purchaseDate, material, weight);
        
        this.type = type;
    }
    
    public Appliance(){}
        
    static public String[] getValidTypes() {
        return validTypes;
    }

    public static String[] getFields() {
        return fields;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
