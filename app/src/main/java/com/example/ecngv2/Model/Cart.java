package com.example.ecngv2.Model;

public class Cart {
    int img;
    String shop, product, price;

    public void setImg(int img) {
        this.img = img;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public void setProduct(String priduct) {
        this.product = priduct;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public String getShop() {
        return shop;
    }

    public String getProduct() {
        return product;
    }

    public String getPrice() {
        return price;
    }

    public Cart(int img, String shop, String product, String price) {
        this.img = img;
        this.shop = shop;
        this.product = product;
        this.price = price;
    }
}
