package com.example.ecngv2.View.SettingAccount;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.ecngv2.R;

public class SettingAccountActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_account);

        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        init();
        btn_back.setOnClickListener(this);
    }

    private void init(){
        btn_back = findViewById(R.id.settingacc_btn_back);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.settingacc_btn_back:
                finish();
                break;
        }
    }
}