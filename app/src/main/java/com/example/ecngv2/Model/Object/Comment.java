package com.example.ecngv2.Model.Object;

public class Comment {
    int avatar, img1, img2;
    float rating;
    String name, cmt;

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public int getAvatar() {
        return avatar;
    }

    public int getImg1() {
        return img1;
    }

    public int getImg2() {
        return img2;
    }

    public float getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getCmt() {
        return cmt;
    }

    public Comment(int avatar, int img1, int img2, float rating, String name, String cmt) {
        this.avatar = avatar;
        this.img1 = img1;
        this.img2 = img2;
        this.rating = rating;
        this.name = name;
        this.cmt = cmt;
    }
}
