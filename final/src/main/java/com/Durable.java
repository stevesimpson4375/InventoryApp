package com;

public class Durable extends InventoryItem{
    
    private String material;
    private Double weight;

    public Durable(String description, Double price, String purchaseDate,
        String material, Double weight){
        super(description, price, purchaseDate);
        this.material = material;
        this.weight = weight;
    }
        
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }    
}
