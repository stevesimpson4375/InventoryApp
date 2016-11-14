/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author steve
 */
public class Appliance extends Durable{

    private String[] validTypes = { "Crock Pot", "Oven" ,"Refrigerator", "Toaster Oven" };
    
    public Appliance(String description, Double price, String purchaseDate,
        String material, Double weight){
        super(description, price, purchaseDate, material, weight);
    }
        
    public String[] getValidTypes() {
        return validTypes;
    }
}
