package com;

import com.googlecode.objectify.annotation.Subclass;
import com.googlecode.objectify.annotation.Index;
import java.text.SimpleDateFormat;
import java.util.Date;

@Subclass(index=true)
public class Appliance extends Durable{
    
    static private String[] fields = { "Description", "Price", "Purchase Date",
        "Material", "Weight (in kg)", "Type of Product"};
    
    @Index
    private String type;
    
    public Appliance(String description, Double price, Date purchaseDate,
        String material, Double weight, String type){
        super(description, price, purchaseDate, material, weight);
        
        this.type = type;
    }
    
    public Appliance(){}

    public static String[] getFields() {
        return fields;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String toString() {
        SimpleDateFormat df = Util.getDateFormat();
        return "This is: " + getDescription() + ", it costs " + getPrice() + 
                ", it was purchased " + getPurchaseDate() + ", it is made of " +
                getMaterial() + ", and it wieghs " + getWeight() + " kg";
    }
}
