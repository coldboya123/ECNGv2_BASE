package com.example.ecngv2.WebService;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class APIService extends AsyncTask<String, Void, String> {
    @Override
    public String doInBackground(String... url) {
        String data = "";
        try {
            URL Url = new URL(url[0]);
            URLConnection urlConnection = Url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            data = bufferedReader.readLine();
            bufferedReader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
