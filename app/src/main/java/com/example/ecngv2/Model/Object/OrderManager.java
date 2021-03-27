package com.example.ecngv2.Model.Object;

import java.util.List;

public class OrderManager {
    String id, time;
    int total;
    List<OrderItem> list;
    boolean ratting;

    public void setRatting(boolean ratting) {
        this.ratting = ratting;
    }

    public boolean isRatting() {
        return ratting;
    }

    public OrderManager(String id, String time, int total, List<OrderItem> list, boolean ratting) {
        this.id = id;
        this.time = time;
        this.total = total;
        this.list = list;
        this.ratting = ratting;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public OrderManager(String id, String time, int total, List<OrderItem> list) {
        this.id = id;
        this.time = time;
        this.total = total;
        this.list = list;
    }
}
