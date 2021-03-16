package com.example.ecngv2.Model.Object;

import java.util.List;

public class OrderItem {
    String shop, shipping;
    List<ProductCartItem> list;


    public void setShop(String shop) {
        this.shop = shop;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public void setList(List<ProductCartItem> list) {
        this.list = list;
    }

    public String getShop() {
        return shop;
    }

    public String getShipping() {
        return shipping;
    }

    public List<ProductCartItem> getList() {
        return list;
    }

    public OrderItem(String shop, String shipping, List<ProductCartItem> list) {
        this.shop = shop;
        this.shipping = shipping;
        this.list = list;
    }
}
