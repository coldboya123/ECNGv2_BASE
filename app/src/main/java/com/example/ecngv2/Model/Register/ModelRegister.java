package com.example.ecngv2.Model.Register;

import com.example.ecngv2.View.MainActivity.MainActivity;
import com.example.ecngv2.WebService.WebService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelRegister {
    public boolean Register(String user, String pwd, String email){
        String url = MainActivity.SERVER_NAME;
        List<HashMap<String, String>> attrs = new ArrayList<>();

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("function", "register");

        HashMap<String, String> hsUser = new HashMap<>();
        hsUser.put("user", user);

        HashMap<String, String> hsPwd = new HashMap<>();
        hsPwd.put("pwd", pwd);

        HashMap<String, String> hsEmail = new HashMap<>();
        hsEmail.put("email", email);

        attrs.add(hashMap);
        attrs.add(hsUser);
        attrs.add(hsPwd);
        attrs.add(hsEmail);

        WebService webService = new WebService(url, attrs);
        webService.execute();
        try {
            String data = webService.get();
            JSONObject jsonObject = new JSONObject(data);
            String jsonResult = jsonObject.getString("result");
            if(jsonResult.equals("true")){
                return true;
            }
        } catch (ExecutionException | InterruptedException | JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}
