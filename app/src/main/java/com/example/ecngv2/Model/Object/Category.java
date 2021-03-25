package com.example.ecngv2.Model.Object;

public class Category {
    protected String title;
    protected int src;
    protected boolean selected;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public Category(String title, int src, boolean selected) {
        this.title = title;
        this.src = src;
        this.selected = selected;
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
