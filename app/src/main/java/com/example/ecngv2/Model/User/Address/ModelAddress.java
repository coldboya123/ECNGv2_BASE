package com.example.ecngv2.Model.User.Address;

import com.example.ecngv2.Model.Object.City;
import com.example.ecngv2.Model.Object.District;
import com.example.ecngv2.Model.Object.Ward;
import com.example.ecngv2.WebService.APIService;
import com.example.ecngv2.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelAddress {
    public List<City> getCity(String url){
        APIService apiService = new APIService();
        apiService.execute(url);
        String data;
        try {
            data = apiService.get();
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            List<City> list = new ArrayList<>();
            for (int i=0; i< jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                list.add(new City(object.getString("province_id"), object.getString("province_name"), object.getString("province_type")));
            }
            return list;
        } catch (ExecutionException | JSONException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<District> getDistrict(String url){
        APIService apiService = new APIService();
        apiService.execute(url);
        String data;
        try {
            data = apiService.get();
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            List<District> list = new ArrayList<>();
            for (int i=0; i< jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                list.add(new District(object.getString("district_id"), object.getString("province_id"), object.getString("district_name"), object.getString("district_type")));
            }
            return list;
        } catch (ExecutionException | JSONException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Ward> getWard(String url){
        APIService apiService = new APIService();
        apiService.execute(url);
        String data;
        try {
            data = apiService.get();
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            List<Ward> list = new ArrayList<>();
            for (int i=0; i< jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                list.add(new Ward(object.getString("ward_id"), object.getString("district_id"), object.getString("ward_name"), object.getString("ward_type")));
            }
            return list;
        } catch (ExecutionException | JSONException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
