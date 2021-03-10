package com.example.ecngv2.Model.Object;

import java.util.List;

public class ProductCart {
    protected String shop;
    List<ProductCartItem> list;
    boolean check;

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }

    public ProductCart(String shop, List<ProductCartItem> list, boolean check) {
        this.shop = shop;
        this.list = list;
        this.check = check;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public void setList(List<ProductCartItem> list) {
        this.list = list;
    }

    public String getShop() {
        return shop;
    }

    public List<ProductCartItem> getList() {
        return list;
    }

}
