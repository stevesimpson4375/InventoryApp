package com;

import java.util.*;
import com.googlecode.objectify.annotation.Subclass;
import com.googlecode.objectify.annotation.Index;
import java.text.*;

@Subclass(index=true)
public class Food extends Consumable{
    
    @Index
    private Date expireDate;
    
    private static String[] fields = { "Description", "Price", "Purchase Date",
        "Expiration Date", "Amount", "Amount Type"};
    
    public Food(String description, Double price, Date purchaseDate,
            Date expireDate, Double amount, String amountType){
        super(description, price, purchaseDate, amount, amountType);
        this.expireDate = expireDate;
    }
    
    public Food(){}

    public static String[] getFields() {
        return fields;
    }
    
    // Returning the date as a formatted string prevents having to format it in the browser
    public String getExpireDate() {
        return df.format(expireDate);
    }
    
    // This explicitly returns a date for this field
    public Date getxpireDateByDate() {
        return expireDate;
    }

    public void setExpireDate(Date exipreDate) {
        this.expireDate = exipreDate;
    }
   
    @Override
    public String toString() {
        return "This is: " + getDescription() + ", it costs " + getPrice() + 
                ", it was purchased " + getPurchaseDate() + ", you have " +
                getAmount() + " " + getAmountType() + ", and it expires " + 
                getExpireDate();
    }
}