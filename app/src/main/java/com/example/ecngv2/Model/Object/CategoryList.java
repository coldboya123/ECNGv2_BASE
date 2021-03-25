package com.example.ecngv2.Model.Object;

import java.util.List;

public class CategoryList {
    protected String title;
    protected List<Category> list;
    protected boolean hide;

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public boolean isHide() {
        return hide;
    }

    public CategoryList(String title, List<Category> list, boolean hide) {
        this.title = title;
        this.list = list;
        this.hide = hide;
    }

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

    public CategoryList(String title, List<Category> list) {
        this.title = title;
        this.list = list;
    }
}
