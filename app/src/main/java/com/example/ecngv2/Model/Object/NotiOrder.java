package com.example.ecngv2.Model.Object;

public class NotiOrder {
    protected int img;
    protected String name, status;

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public NotiOrder(int img, String name, String status) {
        this.img = img;
        this.name = name;
        this.status = status;
    }
}
