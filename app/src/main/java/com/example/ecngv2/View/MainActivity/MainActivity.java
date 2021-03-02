package com.example.ecngv2.View.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.ecngv2.View.Cart.CartActivity;
import com.example.ecngv2.View.Category.CategoryFragment;
import com.example.ecngv2.View.Favorite.FavoriteFragment;
import com.example.ecngv2.View.Home.HomeFragment;
import com.example.ecngv2.R;
import com.example.ecngv2.View.User.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static String SERVER_NAME = "http://192.168.1.239/ECNG/WebService.php";

    LinearLayout cart;
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

        cart.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, CartActivity.class));
        });
    }

    @Override
    public void onBackPressed() {
//        finishAffinity();
//        System.exit(0);
        finish();
        super.onBackPressed();
    }


    private void init(){
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        homefragment = new HomeFragment();
        categoryfragment = new CategoryFragment();
        favoritefragment = new FavoriteFragment();
        userfragment = new UserFragment();
        acivefragment = homefragment;
        cart = findViewById(R.id.cart);
    }

}