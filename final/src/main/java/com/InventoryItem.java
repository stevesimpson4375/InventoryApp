package com;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
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

    public InventoryItem(String description, Double price, Date purchasedate) {
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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String toString() {
        return "This is a " + getDescription();
    }
}
