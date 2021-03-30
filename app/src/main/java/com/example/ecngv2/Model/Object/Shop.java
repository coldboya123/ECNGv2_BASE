package com.example.ecngv2.Model.Object;

public class Shop {
    String name;
    int img;

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public Shop(String name, int img) {
        this.name = name;
        this.img = img;
    }
}
