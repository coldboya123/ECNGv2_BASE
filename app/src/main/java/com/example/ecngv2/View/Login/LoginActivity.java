package com.example.ecngv2.View.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.ecngv2.Presenter.Login.LoginPresenter;
import com.example.ecngv2.R;

public class LoginActivity extends AppCompatActivity implements ILoginView{

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = findViewById(R.id.btn_login);

        LoginPresenter presenter = new LoginPresenter(this);
        btn.setOnClickListener(view -> {
            presenter.ProcessLogin("duchuy", "123456");
        });
    }

    @Override
    public void LoginSuccess() {
        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginFail() {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }
}