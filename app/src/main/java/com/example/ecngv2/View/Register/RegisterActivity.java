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
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, IRegisterView {

    AppCompatButton btn_reg;
    TextInputEditText txtpwd, txtemail;
    String pwd, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
        btn_reg.setOnClickListener(this);
    }

    private void init(){
        btn_reg = findViewById(R.id.register_btn_reg);
        txtemail = findViewById(R.id.register_txtemail);
        txtpwd = findViewById(R.id.register_txtpwd);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register_btn_reg:
//                RegisterPresenter presenter = new RegisterPresenter(this);
//                email = txtemail.getText().toString();
//                pwd = txtpwd.getText().toString();
//                presenter.ProcessRegister(pwd, email);
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void RegisterSuccess() {
//        Toast.makeText(this, "Register success with user: "+ user, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }

    @Override
    public void RegisterFail() {
        Toast.makeText(this, "Register fail!", Toast.LENGTH_SHORT).show();
    }
}