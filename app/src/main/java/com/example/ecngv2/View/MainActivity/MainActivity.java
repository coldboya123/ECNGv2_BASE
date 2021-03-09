package com.example.ecngv2.View.MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.ecngv2.Adapter.ViewpagerMainAdapter;
import com.example.ecngv2.View.Cart.CartActivity;
import com.example.ecngv2.View.Category.CategoryFragment;
import com.example.ecngv2.View.Notification.NotificationFragment;
import com.example.ecngv2.View.Home.HomeFragment;
import com.example.ecngv2.R;
import com.example.ecngv2.View.User.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener, View.OnClickListener{

    public static String SERVER_NAME = "http://192.168.1.239/ECNG/WebService.php";

    LinearLayout cart;
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

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

        viewPager.setAdapter(new ViewpagerMainAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(4);
        viewPager.addOnPageChangeListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        cart.setOnClickListener(this);
    }

    private void init(){
        viewPager = findViewById(R.id.main_viewpager);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        cart = findViewById(R.id.cart);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.bottomnavigation_home:
                viewPager.setCurrentItem(0);
                item.setChecked(true);
                break;
            case R.id.bottomnavigation_category:
                viewPager.setCurrentItem(1);
                item.setChecked(true);
                break;
            case R.id.bottomnavigation_notification:
                viewPager.setCurrentItem(2);
                item.setChecked(true);
                break;
            case R.id.bottomnavigation_user:
                viewPager.setCurrentItem(3);
                item.setChecked(true);
                break;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, CartActivity.class));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                bottomNavigationView.setSelectedItemId(R.id.bottomnavigation_home);
                break;
            case 1:
                bottomNavigationView.setSelectedItemId(R.id.bottomnavigation_category);
                break;
            case 2:
                bottomNavigationView.setSelectedItemId(R.id.bottomnavigation_notification);
                break;
            case 3:
                bottomNavigationView.setSelectedItemId(R.id.bottomnavigation_user);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}