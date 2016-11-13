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
public class HouseHoldProduct extends Grocery{
    private String type;
    
    HouseHoldProduct(String description, Double price, String purchaseDate, String type){
        super(description, price, purchaseDate);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
