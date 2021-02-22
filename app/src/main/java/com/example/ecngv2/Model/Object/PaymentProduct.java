package com.example.ecngv2.Model.Object;

public class PaymentProduct {
    int img, num;
    String name, price;

    public void setImg(int img) {
        this.img = img;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public PaymentProduct(int img, int num, String name, String price) {
        this.img = img;
        this.num = num;
        this.name = name;
        this.price = price;
    }
}
