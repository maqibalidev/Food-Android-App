package com.example.foodapp.Models;

public class Main_Model {
    int image,price;
    String name,descriptiion;

    public int getImage() {
        return image;
    }



    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptiion() {
        return descriptiion;
    }

    public Main_Model() {
    }

    public void setDescriptiion(String descriptiion) {
        this.descriptiion = descriptiion;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Main_Model(int image, String name, String descriptiion, int price) {
        this.image = image;
        this.name = name;
        this.descriptiion = descriptiion;
        this.price = price;
    }
}
