package com.example.ecngv2.View.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecngv2.Presenter.Login.LoginPresenter;
import com.example.ecngv2.R;
import com.example.ecngv2.View.ForgotPwd.ForgotPwdActivity;
import com.example.ecngv2.View.MainActivity.MainActivity;
import com.example.ecngv2.View.Register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    ImageButton btn_back;
    AppCompatButton btnLogin;
    LoginPresenter presenter;
    com.google.android.material.textfield.TextInputEditText user, pwd;
    TextView forgotPwd, register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        init();

        btn_back.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        forgotPwd.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    private void init(){
        btn_back = findViewById(R.id.login_btn_back);
        btnLogin = findViewById(R.id.login_btn_login);
        user = findViewById(R.id.login_txt_user);
        pwd = findViewById(R.id.login_txt_pwd);
        forgotPwd = findViewById(R.id.login_forgot_pwd);
        register = findViewById(R.id.login_register);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_btn_back:
                finish();
                break;
            case R.id.login_btn_login:
                presenter = new LoginPresenter(this, this);
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

    @Override
    public void LoginSuccess() {
        Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void LoginFail() {
        Toast.makeText(this, "Login fail!", Toast.LENGTH_SHORT).show();
    }
}