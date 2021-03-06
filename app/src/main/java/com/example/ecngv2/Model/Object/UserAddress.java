package com.example.ecngv2.Model.Object;

public class UserAddress {
    private String name, phone, address;
    private boolean _default;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void set_default(boolean _default) {
        this._default = _default;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public boolean is_default() {
        return _default;
    }

    public UserAddress(String name, String phone, String address, boolean _default) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this._default = _default;
    }
}
