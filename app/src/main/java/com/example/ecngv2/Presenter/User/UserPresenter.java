package com.example.ecngv2.Presenter.User;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ecngv2.View.User.IUserView;

public class UserPresenter implements IUserPresenter{

    IUserView iUserView;
    Context context;
    SharedPreferences preferences;

    public UserPresenter(IUserView iUserView, Context context) {
        this.iUserView = iUserView;
        this.context = context;
    }

    @Override
    public void CheckLogin() {
        preferences = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        if (preferences.getString("username", "").isEmpty()){
            iUserView.notLogin();
        } else iUserView.Logined();
    }

    @Override
    public void LogOut() {
        preferences = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        preferences.edit().remove("username").apply();
//        System.exit(0);
    }
}
