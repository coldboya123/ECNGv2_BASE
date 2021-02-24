package com.example.ecngv2.View.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecngv2.Presenter.Register.RegisterPresenter;
import com.example.ecngv2.R;
import com.example.ecngv2.View.Login.LoginActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, IRegisterView {

    TextView btn_login;
    AppCompatButton btn_reg;
    com.google.android.material.textfield.TextInputEditText txtuser, txtpwd, txtemail;
    String user, pwd, email;
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
        txtuser = findViewById(R.id.reg_user);
        txtpwd = findViewById(R.id.reg_pwd);
        txtemail = findViewById(R.id.reg_email);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.reg_txt_login:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                break;
            case R.id.reg_btn_reg:
                RegisterPresenter presenter = new RegisterPresenter(this);
                user = txtuser.getText().toString();
                pwd = txtpwd.getText().toString();
                email = txtemail.getText().toString();
                presenter.ProcessRegister(user, pwd, email);
                break;
        }
    }

    @Override
    public void RegisterSuccess() {
        Toast.makeText(this, "Register success with user: "+ user, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }

    @Override
    public void RegisterFail() {
        Toast.makeText(this, "Register fail!", Toast.LENGTH_SHORT).show();
    }
}