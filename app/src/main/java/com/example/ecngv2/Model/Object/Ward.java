package com.example.ecngv2.Model.Object;

public class Ward {
    public void setId(String id) {
        this.id = id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
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

    public String getDistrict_id() {
        return district_id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Ward(String id, String district_id, String name, String type) {
        this.id = id;
        this.district_id = district_id;
        this.name = name;
        this.type = type;
    }

    String id, district_id, name, type;


}
