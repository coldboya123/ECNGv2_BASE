package com.example.ecngv2.View.Wellcome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.ecngv2.R;
import com.example.ecngv2.View.MainActivity.MainActivity;

import java.util.Locale;

public class WellcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);

        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        new Thread(() -> {
            try{
                Thread.sleep(0);
            } catch (Exception e){

            }finally {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        }).start();
    }
}