package com.example.ecngv2.Model.Object;

public class ProductCartItem {
    int img, num, price;
    String name, property;
    boolean check;

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getImg() {
        return img;
    }

    public int getNum() {
        return num;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public String getName() {
        return name;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public ProductCartItem(int img, int num, String name, int price, String property, boolean check) {
        this.img = img;
        this.num = num;
        this.price = price;
        this.name = name;
        this.property = property;
        this.check = check;
    }
}
