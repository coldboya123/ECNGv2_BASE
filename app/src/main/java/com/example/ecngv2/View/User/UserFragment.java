package com.example.ecngv2.View.User;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecngv2.Presenter.User.UserPresenter;
import com.example.ecngv2.R;
import com.example.ecngv2.View.Login.LoginActivity;
import com.example.ecngv2.View.MainActivity.MainActivity;
import com.example.ecngv2.View.Register.RegisterActivity;
import com.example.ecngv2.View.User.SettingAccount.SettingAccountActivity;

public class UserFragment extends Fragment implements View.OnClickListener, IUserView {

    ConstraintLayout block_logined, block_logouted, btn_settingacc;
    AppCompatButton btn_login, btn_logout, btn_register;
    UserPresenter presenter;
    TextView badge_choxacnhan, badge_cholayhang, badge_danggiao, badge_dagiao;
    boolean checkLogin = false;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        init(v);

        presenter = new UserPresenter(this, getContext());
        presenter.CheckLogin();

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_logout.setOnClickListener(this);
        btn_settingacc.setOnClickListener(this);

        return v;
    }

    private void init(View v){
        block_logined = v.findViewById(R.id.user_block_logined);
        btn_register = v.findViewById(R.id.user_btn_register);
        block_logouted = v.findViewById(R.id.user_block_logouted);
        btn_login = v.findViewById(R.id.user_btn_login);
        btn_settingacc = v.findViewById(R.id.user_block_setting);
        btn_logout = v.findViewById(R.id.user_btn_logout);

        badge_choxacnhan = v.findViewById(R.id.user_badge_choxacnhan);
        badge_cholayhang = v.findViewById(R.id.user_badge_cholayhang);
        badge_danggiao = v.findViewById(R.id.user_badge_danggiao);
        badge_dagiao = v.findViewById(R.id.user_badge_dagiao);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_btn_login:
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
            case R.id.user_btn_register:
                startActivity(new Intent(getContext(), RegisterActivity.class));
                break;
            case R.id.user_btn_logout:
                presenter.LogOut();
                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finish();
                break;
            case R.id.user_block_setting:
                if (checkLogin){
                    startActivity(new Intent(getContext(), SettingAccountActivity.class));
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
        }
    }

    @Override
    public void Logined() {
        checkLogin = true;
        block_logouted.setVisibility(View.GONE);
        block_logined.setVisibility(View.VISIBLE);
        btn_logout.setVisibility(View.VISIBLE);
        badge_choxacnhan.setVisibility(View.VISIBLE);
        badge_cholayhang.setVisibility(View.VISIBLE);
        badge_danggiao.setVisibility(View.VISIBLE);
        badge_dagiao.setVisibility(View.VISIBLE);
    }

    @Override
    public void notLogin() {
        checkLogin = false;
        Toast.makeText(getContext(), "not login", Toast.LENGTH_SHORT).show();
    }
}