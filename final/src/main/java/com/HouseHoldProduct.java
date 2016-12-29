package com;

import com.googlecode.objectify.annotation.Subclass;
import com.googlecode.objectify.annotation.Index;
import java.text.SimpleDateFormat;
import java.util.Date;

@Subclass(index=true)
public class HouseHoldProduct extends Consumable{
    
    @Index private String type;
    
    static private String[] validTypes = { "Paper Towels", "Soap",
        "Toilet Paper" };
    
    static private String[] fields = { "Description", "Price", "Purchase Date",
        "Amount", "Amount Type"}; // The field "type" is omitted do to select box prompt
    
    public HouseHoldProduct(String description, Double price, Date purchaseDate,
            Double amount, String amountType, String type){
        super(description, price, purchaseDate, amount, amountType);
        this.type = type;
    }
    
    public HouseHoldProduct(){};
    
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
    
    @Override
    public String toString() {
        SimpleDateFormat df = Util.getDateFormat();
        return "This is: " + getDescription() + ", it costs " + getPrice() + 
                ", it was purchased " + df.format(getPurchaseDate()) + ", and you have " +
                getAmount() + " " + getAmountType();
    }
}