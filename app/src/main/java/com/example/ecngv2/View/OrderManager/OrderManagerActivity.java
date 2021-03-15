package com.example.ecngv2.View.OrderManager;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.ecngv2.Adapter.ViewPagerOrderManagerAdapter;
import com.example.ecngv2.R;
import com.google.android.material.tabs.TabLayout;

public class OrderManagerActivity extends AppCompatActivity implements View.OnClickListener {

    SwipeRefreshLayout refreshLayout;
    ImageButton btn_back;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_manager);

        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        init();

        refreshLayout.setOnRefreshListener(() -> refreshLayout.setRefreshing(false));
        viewPager.setAdapter(new ViewPagerOrderManagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        btn_back.setOnClickListener(this);

    }

    private void init(){
        refreshLayout = findViewById(R.id.refresh_ordermanager);
        btn_back = findViewById(R.id.ordermanager_btn_back);
        viewPager = findViewById(R.id.ordermanager_viewpager);
        tabLayout = findViewById(R.id.ordermanager_tab);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ordermanager_btn_back:
                finish();
                break;
        }
    }
}