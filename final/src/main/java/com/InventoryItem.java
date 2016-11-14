package com;

public class InventoryItem {

    private String description;
    private Double price;
    private String purchaseDate;
    
    public InventoryItem(String description, Double price, String purchasedate){
        this.description = description;
        this.price = price;
        this.purchaseDate = purchaseDate;
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

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
