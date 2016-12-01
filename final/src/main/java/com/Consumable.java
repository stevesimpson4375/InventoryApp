package com;

public class Consumable extends InventoryItem{
    
    private Double amount;
    private String amountType;
    
    public Consumable(String description, Double price, String purchaseDate,
            Double amount, String amountType){
        super(description, price, purchaseDate);
        this.amount = amount;
        this.amountType = amountType;
    }   

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }
}
