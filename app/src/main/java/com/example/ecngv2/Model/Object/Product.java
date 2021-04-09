package com.example.ecngv2.Model.Object;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    int img, numrating, price;
    String name;
    Float rating;
    List<Integer> listImg;

    public Product(int img, int price, String name, List<Integer> listImg) {
        this.img = img;
        this.price = price;
        this.name = name;
        this.listImg = listImg;
    }

    public Product(int img, String name, int price) {
        this.img = img;
        this.price = price;
        this.name = name;
    }

    public Product(int img, int price) {
        this.img = img;
        this.price = price;
    }

    public void setListImg(List<Integer> listImg) {
        this.listImg = listImg;
    }

    public List<Integer> getListImg() {
        return listImg;
    }

    public Product(int img, int numrating, String name, int price, Float rating) {
        this.img = img;
        this.numrating = numrating;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Product(int img, Float rating, int numrating, String name, int price, List<Integer> listImg) {
        this.img = img;
        this.numrating = numrating;
        this.price = price;
        this.name = name;
        this.rating = rating;
        this.listImg = listImg;
    }

    public void setNumrating(int numrating) {
        this.numrating = numrating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
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

    public int getPrice() {
        return price;
    }

    public Float getRating() {
        return rating;
    }
}
