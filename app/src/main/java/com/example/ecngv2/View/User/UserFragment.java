package com.example.ecngv2.View.User;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ecngv2.R;
import com.example.ecngv2.View.Login.LoginActivity;
import com.example.ecngv2.View.SettingAccount.SettingAccountActivity;

public class UserFragment extends Fragment implements View.OnClickListener {

    ConstraintLayout btn_settingacc;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        init(v);
//        Button btn = v.findViewById(R.id.user_btn_login);
//        btn.setOnClickListener(view -> {
//            startActivity(new Intent(getContext(), LoginActivity.class));
//        });

        btn_settingacc.setOnClickListener(this);

        return v;
    }

    private void init(View v){
        btn_settingacc = v.findViewById(R.id.user_block_setting);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_block_setting:
                startActivity(new Intent(getContext(), SettingAccountActivity.class));
                break;
        }
    }
}