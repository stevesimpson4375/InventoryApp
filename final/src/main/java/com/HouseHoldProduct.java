package com;

public class HouseHoldProduct extends Grocery{
    private String type;
    static private String[] validTypes = { "Fork", "Microwave", "Paper Towels",
        "Toilet Paper" , "Knife", "Toaster Oven" };
    
    public HouseHoldProduct(String description, Double price, String purchaseDate, String type){
        super(description, price, purchaseDate);
        this.type = type;
    }
    
    static public String[] getValidTypes() {
        return validTypes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
