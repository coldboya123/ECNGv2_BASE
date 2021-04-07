package com.example.ecngv2.View.Address;

import com.example.ecngv2.Model.Object.City;
import com.example.ecngv2.Model.Object.District;
import com.example.ecngv2.Model.Object.Ward;

public interface IAddUserAddress {
    void OnSelectedCity(City city);
    void OnSelectedDistrict(District district);
    void OnSelectedWard(Ward ward);
}
