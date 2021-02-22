package com.example.ecngv2.Model.Object;

public class Cate_tabItem {
    String title;
    int img_normal, img_selected;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImg_normal(int img_normal) {
        this.img_normal = img_normal;
    }

    public void setImg_selected(int img_selected) {
        this.img_selected = img_selected;
    }

    public String getTitle() {
        return title;
    }

    public int getImg_normal() {
        return img_normal;
    }

    public int getImg_selected() {
        return img_selected;
    }

    public Cate_tabItem(String title, int img_normal, int img_selected) {
        this.title = title;
        this.img_normal = img_normal;
        this.img_selected = img_selected;
    }
}
