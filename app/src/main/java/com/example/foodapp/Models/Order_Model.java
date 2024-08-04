package com.example.foodapp.Models;

public class Order_Model {
    int id,image,price,quantity;
    String f_name,f_disc,name,number,adress;





    public Order_Model(int image, int price, String f_name, String f_disc) {
        this.image = image;
        this.price = price;
        this.f_name = f_name;
        this.f_disc = f_disc;
    }

    public Order_Model(int image, int price, int quantity, String f_name, String f_disc, String name, String number, String adress) {
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.f_name = f_name;
        this.f_disc = f_disc;
        this.name = name;
        this.number = number;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getF_disc() {
        return f_disc;
    }

    public void setF_disc(String f_disc) {
        this.f_disc = f_disc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Order_Model() {
    }

    public Order_Model(int id, int image, int price, int quantity, String f_name, String f_disc, String name, String number, String adress) {
        this.id = id;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.f_name = f_name;
        this.f_disc = f_disc;
        this.name = name;
        this.number = number;
        this.adress = adress;
    }
}
