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
    
    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date exipreDate) {
        this.expireDate = exipreDate;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat df = Util.getDateFormat();
        return "This is: " + getDescription() + " and it expires " + 
                df.format(getExpireDate());
    }
}