package com.example.ecngv2.View.Wellcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.TextView;

import com.example.ecngv2.R;
import com.example.ecngv2.View.MainActivity.MainActivity;

public class WellcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);

        new Thread(() -> {
            try{
                Thread.sleep(500);
            } catch (Exception e){

            }finally {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        }).start();
    }
}