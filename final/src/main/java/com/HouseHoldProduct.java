package com;

public class HouseHoldProduct extends Consumable{
    private String type;
    static private String[] validTypes = { "Paper Towels", "soap",
        "Toilet Paper" };
    
    public HouseHoldProduct(String description, Double price, String purchaseDate,
            Double amount, String amountType, String type){
        super(description, price, purchaseDate, amount, amountType);
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
