package com.example.ecngv2.Presenter.Register;

import com.example.ecngv2.Model.Register.ModelRegister;
import com.example.ecngv2.View.Register.IRegisterView;

public class RegisterPresenter implements IRegisterPresenter{

    IRegisterView view;

    public RegisterPresenter(IRegisterView view) {
        this.view = view;
    }

    @Override
    public void ProcessRegister(String user, String pwd, String email) {
        ModelRegister register = new ModelRegister();
        if (register.Register(user, pwd, email)){
            view.RegisterSuccess();
        } else {
            view.RegisterFail();
        }
    }
}
