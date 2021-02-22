package com.example.ecngv2.Presenter.Login;

import android.content.Context;

import com.example.ecngv2.Model.Login.ModelLogin;
import com.example.ecngv2.View.Login.ILoginView;

public class LoginPresenter implements  ILoginPresenter{

    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void ProcessLogin(String user, String pwd) {
        ModelLogin modelLogin = new ModelLogin();
        if (modelLogin.CheckLogin(user, pwd))
            iLoginView.LoginSuccess();
        else iLoginView.LoginFail();
    }
}
