package com.example.ecngv2.View.User;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecngv2.Presenter.User.UserPresenter;
import com.example.ecngv2.R;
import com.example.ecngv2.View.Login.LoginActivity;
import com.example.ecngv2.View.MainActivity.MainActivity;
import com.example.ecngv2.View.OrderManager.OrderManagerActivity;
import com.example.ecngv2.View.Register.RegisterActivity;
import com.example.ecngv2.View.User.SettingAccount.SettingAccountActivity;
import com.example.ecngv2.View.Voucher.VoucherActivity;
import com.google.android.material.imageview.ShapeableImageView;

public class UserFragment extends Fragment implements View.OnClickListener, IUserView {

    SwipeRefreshLayout refreshLayout;
    ShapeableImageView avatar;
    ImageView choxacnhan, cholayhang, danggiao, dagiao, dahuy;
    ConstraintLayout block_logined, block_logouted, btn_settingacc, btn_voucher;
    AppCompatButton btn_login, btn_logout, btn_register;
    UserPresenter presenter;
    TextView badge_choxacnhan, badge_cholayhang, badge_danggiao, badge_dagiao, ordermanager;
    boolean checkLogin = false;
    Intent intent; 

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        init(v);

        refreshLayout.setOnRefreshListener(() -> refreshLayout.setRefreshing(false));

        presenter = new UserPresenter(this, getContext());
        presenter.CheckLogin();

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_logout.setOnClickListener(this);
        btn_settingacc.setOnClickListener(this);
        btn_voucher.setOnClickListener(this);
        ordermanager.setOnClickListener(this);
        choxacnhan.setOnClickListener(this);
        cholayhang.setOnClickListener(this);
        danggiao.setOnClickListener(this);
        dagiao.setOnClickListener(this);
        dahuy.setOnClickListener(this);
        return v;
    }

    private void init(View v){
        refreshLayout = v.findViewById(R.id.refresh_user);

        avatar = v.findViewById(R.id.user_avatar);
        block_logined = v.findViewById(R.id.user_block_logined);
        btn_register = v.findViewById(R.id.user_btn_register);
        block_logouted = v.findViewById(R.id.user_block_logouted);
        btn_login = v.findViewById(R.id.user_btn_login);
        btn_settingacc = v.findViewById(R.id.user_block_setting);
        btn_logout = v.findViewById(R.id.user_btn_logout);
        btn_voucher = v.findViewById(R.id.user_block_voucher);

        ordermanager = v.findViewById(R.id.user_ordermanager);
        badge_choxacnhan = v.findViewById(R.id.user_badge_choxacnhan);
        badge_cholayhang = v.findViewById(R.id.user_badge_cholayhang);
        badge_danggiao = v.findViewById(R.id.user_badge_danggiao);
        badge_dagiao = v.findViewById(R.id.user_badge_dagiao);

        choxacnhan = v.findViewById(R.id.user_confirm);
        cholayhang = v.findViewById(R.id.user_pickup);
        danggiao = v.findViewById(R.id.user_delivering);
        dagiao = v.findViewById(R.id.user_delivered);
        dahuy = v.findViewById(R.id.user_cancel);
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
            case R.id.user_ordermanager:
                startActivity(new Intent(getContext(), OrderManagerActivity.class));
                break;
            case R.id.user_confirm:
                intent = new Intent(getContext(), OrderManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.user_pickup:
                intent = new Intent(getContext(), OrderManagerActivity.class);
                intent.putExtra("position", 1);
                startActivity(intent);
                break;
            case R.id.user_delivering:
                intent = new Intent(getContext(), OrderManagerActivity.class);
                intent.putExtra("position", 2);
                startActivity(intent);
                break;
            case R.id.user_delivered:
                intent = new Intent(getContext(), OrderManagerActivity.class);
                intent.putExtra("position", 3);
                startActivity(intent);
                break;
            case R.id.user_cancel:
                intent = new Intent(getContext(), OrderManagerActivity.class);
                intent.putExtra("position", 4);
                startActivity(intent);
                break;
            case R.id.user_block_voucher:
                if (checkLogin){
                    startActivity(new Intent(getContext(), VoucherActivity.class));
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
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
        avatar.setImageResource(R.drawable.tenor);
        block_logouted.setVisibility(View.GONE);
        block_logined.setVisibility(View.VISIBLE);
        btn_logout.setVisibility(View.VISIBLE);
        badge_choxacnhan.setVisibility(View.VISIBLE);
//        badge_cholayhang.setVisibility(View.VISIBLE);
        badge_danggiao.setVisibility(View.VISIBLE);
        badge_dagiao.setVisibility(View.VISIBLE);
    }

    @Override
    public void notLogin() {
        checkLogin = false;
        Toast.makeText(getContext(), "not login", Toast.LENGTH_SHORT).show();
    }
}