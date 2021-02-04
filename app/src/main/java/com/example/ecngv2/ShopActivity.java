package com.example.ecngv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ecngv2.Adapter.ViewPager_Shop_Adapter;
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