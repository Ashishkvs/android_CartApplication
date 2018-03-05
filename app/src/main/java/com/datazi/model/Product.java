package com.datazi.model;

/**
 * Created by Ashish on 3/5/2018.
 */

public class Product {
    private String name;
    private int image;
    private double price;
    private int qty;

    public Product(){}

    public Product(String name, int image, double price, int qty) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
