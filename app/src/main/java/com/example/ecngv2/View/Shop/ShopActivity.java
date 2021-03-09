package com.example.ecngv2.View.Shop;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.ecngv2.Adapter.ViewPager_Shop_Adapter;
import com.example.ecngv2.R;
import com.google.android.material.tabs.TabLayout;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;
    TabLayout tabs;
    ImageButton btn_back;
    TextView btn_follow;
    boolean check_follow = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        init();
        ViewPager_Shop_Adapter adapter = new ViewPager_Shop_Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
        btn_back.setOnClickListener(this);
        btn_follow.setOnClickListener(this);
    }

    private void init(){
        viewPager = findViewById(R.id.shop_viewpager);
        tabs = findViewById(R.id.shop_tab);
        btn_back = findViewById(R.id.shop_btn_back);
        btn_follow = findViewById(R.id.shop_btn_follow);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.shop_btn_back:
                finish();
                break;
            case R.id.shop_btn_follow:
                check_follow = !check_follow;
                if (check_follow){
                    btn_follow.setBackground(getDrawable(R.drawable.background_radius_primary_color));
                    btn_follow.setTextColor(getColor(R.color.white));
                    btn_follow.setText("Đã theo dõi");
                } else {
                    btn_follow.setBackground(getDrawable(R.drawable.border_radius_primary_color));
                    btn_follow.setTextColor(getColor(R.color.primary_color));
                    btn_follow.setText("Theo dõi");
                }
                break;
        }
    }
}