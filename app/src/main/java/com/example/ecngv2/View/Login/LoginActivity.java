package com.example.ecngv2.View.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecngv2.Presenter.Login.LoginPresenter;
import com.example.ecngv2.R;
import com.example.ecngv2.View.ForgotPwd.ForgotPwdActivity;
import com.example.ecngv2.View.MainActivity.MainActivity;
import com.example.ecngv2.View.Register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    AppCompatButton btnLogin;
    LoginPresenter presenter;
    com.google.android.material.textfield.TextInputEditText user, pwd;
    TextView forgotPwd, register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        btnLogin.setOnClickListener(this);
        forgotPwd.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    private void init(){
        btnLogin = findViewById(R.id.login_btn_login);
        user = findViewById(R.id.login_txt_user);
        pwd = findViewById(R.id.login_txt_pwd);
        forgotPwd = findViewById(R.id.login_forgot_pwd);
        register = findViewById(R.id.login_register);
    }

    @Override
    public void LoginSuccess() {
        Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void LoginFail() {
        Toast.makeText(this, "Login fail!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_btn_login:
                presenter = new LoginPresenter(this);
                presenter.ProcessLogin(user.getText().toString(), pwd.getText().toString());
                break;
            case R.id.login_forgot_pwd:
                startActivity(new Intent(LoginActivity.this, ForgotPwdActivity.class));
                break;
            case R.id.login_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }
}