package com.example.ecngv2.Model.Object;

import java.util.List;

public class ItemCateTab {
    String title;
    List<Category> list;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public List<Category> getList() {
        return list;
    }

    public ItemCateTab(String title, List<Category> list) {
        this.title = title;
        this.list = list;
    }
}
