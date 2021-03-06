package com.example.ecngv2.Model.Object;

public class District {
    String id, city_id, name, type;

    public void setId(String id) {
        this.id = id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
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

    public String getCity_id() {
        return city_id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public District(String id, String city_id, String name, String type) {
        this.id = id;
        this.city_id = city_id;
        this.name = name;
        this.type = type;
    }
}
