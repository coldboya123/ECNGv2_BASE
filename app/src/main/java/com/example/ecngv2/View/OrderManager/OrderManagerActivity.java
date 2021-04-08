package com.example.ecngv2.View.OrderManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.ecngv2.Adapter.ViewPagerOrderManagerAdapter;
import com.example.ecngv2.R;
import com.example.ecngv2.View.MainActivity.MainActivity;
import com.google.android.material.tabs.TabLayout;

public class OrderManagerActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_back;
    ViewPager viewPager;
    TabLayout tabLayout;
    Intent intent;
    int position;

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

        viewPager.setAdapter(new ViewPagerOrderManagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        position = intent.getIntExtra("position", 0);
        viewPager.setCurrentItem(position, false);
        btn_back.setOnClickListener(this);

    }

    private void init(){
        intent = getIntent();
        btn_back = findViewById(R.id.ordermanager_btn_back);
        viewPager = findViewById(R.id.ordermanager_viewpager);
        tabLayout = findViewById(R.id.ordermanager_tab);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ordermanager_btn_back:
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                break;
        }
    }
}