package com.example.ecngv2.View.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ecngv2.R;
import com.example.ecngv2.View.Login.LoginActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView btn_login;
    AppCompatButton btn_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
        btn_login.setOnClickListener(this);
        btn_reg.setOnClickListener(this);
    }

    private void init(){
        btn_login = findViewById(R.id.reg_txt_login);
        btn_reg = findViewById(R.id.reg_btn_reg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.reg_txt_login:
            case R.id.reg_btn_reg:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                break;
        }
    }
}