package com.example.ecngv2.Model.Object;

import java.util.List;

public class ProductPayment {
    protected String shop;
    List<ProductCartItem> list;
    int shipping;

    public void setShipping(int shipping) {
        this.shipping = shipping;
    }

    public int getShipping() {
        return shipping;
    }

    public ProductPayment(String shop, List<ProductCartItem> list, int shipping) {
        this.shop = shop;
        this.list = list;
        this.shipping = shipping;
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
