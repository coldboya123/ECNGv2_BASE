package com.example.ecngv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.ecngv2.Adapter.ViewPager_Shop_Adapter;
import com.google.android.material.tabs.TabLayout;

public class ShopActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        init();
        ViewPager_Shop_Adapter adapter = new ViewPager_Shop_Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
    }

    private void init(){
        viewPager = findViewById(R.id.shop_viewpager);
        tabs = findViewById(R.id.shop_tab);
    }
}