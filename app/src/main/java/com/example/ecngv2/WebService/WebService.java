package com.example.ecngv2.WebService;

import android.net.Uri;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebService extends AsyncTask<String, Void, String> {

    String urls;
    List<HashMap<String, String>> attrs;
    StringBuilder dataBuilder;
    boolean method;

    public WebService(String url) {
        this.urls = url;
        method = true;
    }

    public WebService(String url, List<HashMap<String, String>> attrs) {
        this.urls = url;
        this.attrs = attrs;
        method = false;
    }

    @Override
    protected String doInBackground(String... strings) {
        String data = "";
        try {
            URL url = new URL(urls);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            if (!method){
                data = methodPost(httpURLConnection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private String methodGet(HttpURLConnection httpURLConnection){
        String data = "";
        InputStream inputStream;
        try {
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            dataBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                dataBuilder.append(line);
            }

            data = dataBuilder.toString();
            bufferedReader.close();
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    private String methodPost(HttpURLConnection httpURLConnection){
        String data = "";
        String key = "";
        String value = "";

        try {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            Uri.Builder builder = new Uri.Builder();
            int count = attrs.size();
            for(int i=0;i<count;i++){

                for(Map.Entry<String,String> values : attrs.get(i).entrySet()){
                    key = values.getKey();
                    value = values.getValue();
                }

                builder.appendQueryParameter(key,value);
            }
            String query = builder.build().getEncodedQuery();

            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter writer = new BufferedWriter(streamWriter);

            writer.write(query);
            writer.flush();
            writer.close();
            streamWriter.close();
            outputStream.close();

            data = methodGet(httpURLConnection);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
