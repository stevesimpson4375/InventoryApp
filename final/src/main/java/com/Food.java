/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.*;

/**
 *
 * @author steve
 */
public class Food extends Grocery{
    
    private String expireDate;
    
    public Food(String description, Double price, String purchaseDate, String expireDate){
        super(description, price, purchaseDate);
        this.expireDate = expireDate;
    }

    public String getExipreDate() {
        return expireDate;
    }

    public void setExipreDate(String exipreDate) {
        this.expireDate = exipreDate;
    } 
}
