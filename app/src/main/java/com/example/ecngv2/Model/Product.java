package com.example.ecngv2.Model;

public class Product {
    int img, numrating;
    String name, price;
    Float rating;

    public void setImg(int img) {
        this.img = img;
    }

    public void setNumrating(int numrating) {
        this.numrating = numrating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public int getImg() {
        return img;
    }

    public int getNumrating() {
        return numrating;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Float getRating() {
        return rating;
    }

    public Product(int img, int numrating, String name, String price, Float rating) {
        this.img = img;
        this.numrating = numrating;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}
