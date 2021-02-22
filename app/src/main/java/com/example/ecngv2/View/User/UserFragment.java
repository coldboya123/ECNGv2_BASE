package com.example.ecngv2.View.User;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ecngv2.R;
import com.example.ecngv2.View.Login.LoginActivity;

public class UserFragment extends Fragment {


    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        Button btn = v.findViewById(R.id.user_btn_login);
        btn.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), LoginActivity.class));
        });
        return v;
    }
}