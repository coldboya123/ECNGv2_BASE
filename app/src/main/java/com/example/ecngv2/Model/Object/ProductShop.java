package com.example.ecngv2.Model.Object;

public class ProductShop {
    int img;
    String name, price1, price2;

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getPrice1() {
        return price1;
    }

    public String getPrice2() {
        return price2;
    }

    public ProductShop(int img, String name, String price1, String price2) {
        this.img = img;
        this.name = name;
        this.price1 = price1;
        this.price2 = price2;
    }
}
