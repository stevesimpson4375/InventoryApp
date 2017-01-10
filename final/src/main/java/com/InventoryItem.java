package com;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class InventoryItem {

    public Key<InventoryItem> getKey() {
        return Key.create(InventoryItem.class, id);
    }
    @Id
    Long id;
    @Index
    private String description;
    @Index
    private Double price;
    @Index
    private Date purchaseDate;
    
    static protected SimpleDateFormat df = Util.getDateFormat();

    public InventoryItem(String description, Double price, Date purchaseDate) {
        this.description = description;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    public InventoryItem() {
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Returning the date as a formatted string prevents having to format it in the browser
    public String getPurchaseDate() {
        return df.format(purchaseDate);
    }
    
    // This explicitly returns a date for this field
    public Date getPurchaseDateByDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String toString() {
        return "This is a " + getDescription();
    }
}
