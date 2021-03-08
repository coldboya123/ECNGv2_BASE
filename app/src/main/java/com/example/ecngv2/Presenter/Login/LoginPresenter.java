package com.example.ecngv2.Presenter.Login;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ecngv2.Model.Login.ModelLogin;
import com.example.ecngv2.View.Login.ILoginView;

public class LoginPresenter implements  ILoginPresenter{

    ILoginView iLoginView;
    Context context;

    public LoginPresenter(ILoginView iLoginView, Context context) {
        this.iLoginView = iLoginView;
        this.context = context;
    }

    @Override
    public void ProcessLogin(String user, String pwd) {
//        ModelLogin modelLogin = new ModelLogin();
//        if (modelLogin.CheckLogin(user, pwd))
//            iLoginView.LoginSuccess();
//        else iLoginView.LoginFail();
        SharedPreferences preferences = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", user);
        editor.putString("password", pwd);
        editor.apply();
        iLoginView.LoginSuccess();
    }
}
