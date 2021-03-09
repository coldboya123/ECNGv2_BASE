package com.example.ecngv2.Model.Object;

public class NotiSecure {
    protected String date, content;
    protected boolean status;

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public boolean isStatus() {
        return status;
    }

    public NotiSecure(String date, String content, boolean status) {
        this.date = date;
        this.content = content;
        this.status = status;
    }
}
