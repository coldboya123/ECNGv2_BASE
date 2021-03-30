package com.example.ecngv2.Model.Object;

public class FavProduct extends Product{
    String shopname;
    int shopimg;

    public void setShopimg(int shopimg) {
        this.shopimg = shopimg;
    }

    public int getShopimg() {
        return shopimg;
    }

    public FavProduct(int img, String name, int price, String shopname, int shopimg) {
        super(img, name, price);
        this.shopname = shopname;
        this.shopimg = shopimg;
    }


    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getShopname() {
        return shopname;
    }
}
