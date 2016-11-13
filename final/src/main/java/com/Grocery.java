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
public class Grocery {

    private String description;
    private Double price;
    private String purchaseDate;
    private String expireDate;

    public Grocery(String description, Double price, String purchaseDate) {
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

    public String getExipreDate() {
        return expireDate;
    }

    public void setExipreDate(String exipreDate) {
        this.expireDate = exipreDate;
    }
}
