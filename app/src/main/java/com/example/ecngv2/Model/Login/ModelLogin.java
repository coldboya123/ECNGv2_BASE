package com.example.ecngv2.Model.Login;

import android.content.Context;
import android.util.Log;

import com.example.ecngv2.View.MainActivity.MainActivity;
import com.example.ecngv2.WebService.WebService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelLogin {
    public boolean CheckLogin(String user, String pwd){
        String url = MainActivity.SERVER_NAME;
        List<HashMap<String, String>> attrs = new ArrayList<>();

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("function", "login");

        HashMap<String, String> hsUser = new HashMap<>();
        hsUser.put("user", user);

        HashMap<String, String> hsPwd = new HashMap<>();
        hsPwd.put("pwd", pwd);

        attrs.add(hashMap);
        attrs.add(hsUser);
        attrs.add(hsPwd);

        WebService webService = new WebService(url, attrs);
        webService.execute();
        try {
            String data = webService.get();
            JSONObject jsonObject = new JSONObject(data);
            String jsonKetQua = jsonObject.getString("result");
            if(jsonKetQua.equals("true")){
                return true;
            }
        } catch (ExecutionException | InterruptedException | JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}
