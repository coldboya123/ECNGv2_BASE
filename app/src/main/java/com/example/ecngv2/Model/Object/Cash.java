package com.example.ecngv2.Model.Object;

public class Cash {
    String id, date;
    int money;

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getMoney() {
        return money;
    }

    public Cash(String id, String date, int money) {
        this.id = id;
        this.date = date;
        this.money = money;
    }
}
