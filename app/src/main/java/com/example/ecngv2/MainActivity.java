package com.example.ecngv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentManager fm = getSupportFragmentManager();
    Fragment homefragment, categoryfragment, favoritefragment, userfragment, acivefragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        init();
        fm.beginTransaction().add(R.id.main_container, userfragment, "user").hide(userfragment).commit();
        fm.beginTransaction().add(R.id.main_container, favoritefragment, "favorite").hide(favoritefragment).commit();
        fm.beginTransaction().add(R.id.main_container, categoryfragment, "category").hide(categoryfragment).commit();
        fm.beginTransaction().add(R.id.main_container, homefragment, "home").commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.bottomnavigation_home:
                    fm.beginTransaction().hide(acivefragment).show(homefragment).commit();
                    acivefragment = homefragment;
                    return true;
                case R.id.bottomnavigation_category:
                    fm.beginTransaction().hide(acivefragment).show(categoryfragment).commit();
                    acivefragment = categoryfragment;
                    return true;
                case R.id.bottomnavigation_favorite:
                    fm.beginTransaction().hide(acivefragment).show(favoritefragment).commit();
                    acivefragment = favoritefragment;
                    return true;
                case R.id.bottomnavigation_user:
                    fm.beginTransaction().hide(acivefragment).show(userfragment).commit();
                    acivefragment = userfragment;
                    return true;
            }
            return false;
        });
    }
    private void init(){
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        homefragment = new HomeFragment();
        categoryfragment = new CategoryFragment();
        favoritefragment = new FavoriteFragment();
        userfragment = new UserFragment();
        acivefragment = homefragment;
    }
}