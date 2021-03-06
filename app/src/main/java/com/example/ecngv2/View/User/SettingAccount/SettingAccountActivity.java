package com.example.ecngv2.View.User.SettingAccount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.ecngv2.R;
import com.example.ecngv2.View.User.SettingAccount.Address.UserAddressActivity;
import com.example.ecngv2.View.User.SettingAccount.Profile.UserProfileActivity;

public class SettingAccountActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_back;
    ConstraintLayout btn_profile, btn_address;
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
        btn_profile.setOnClickListener(this);
        btn_address.setOnClickListener(this);
    }

    private void init(){
        btn_back = findViewById(R.id.settingacc_btn_back);
        btn_profile = findViewById(R.id.settingacc_block_profile);
        btn_address = findViewById(R.id.settingacc_block_address);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.settingacc_btn_back:
                finish();
                break;
            case R.id.settingacc_block_profile:
                startActivity(new Intent(SettingAccountActivity.this, UserProfileActivity.class));
                break;
            case R.id.settingacc_block_address:
                startActivity(new Intent(SettingAccountActivity.this, UserAddressActivity.class));
                break;
        }
    }
}