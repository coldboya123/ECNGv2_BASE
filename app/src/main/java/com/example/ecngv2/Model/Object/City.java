package com.example.ecngv2.Model.Object;

public class City {
    String id, name, type;


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public City(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}
