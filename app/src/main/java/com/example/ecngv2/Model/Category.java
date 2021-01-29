package com.example.ecngv2.Model;

public class Category {
    protected String title;
    protected int src;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public int getSrc() {
        return src;
    }

    public Category(String title, int src) {
        this.title = title;
        this.src = src;
    }
}
