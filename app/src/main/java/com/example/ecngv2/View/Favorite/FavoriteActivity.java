package com.example.ecngv2.View.Favorite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.ecngv2.Adapter.ViewPagerFavoriteAdapter;
import com.example.ecngv2.R;
import com.google.android.material.tabs.TabLayout;

public class FavoriteActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        init();

        viewPager.setAdapter(new ViewPagerFavoriteAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        btn_back.setOnClickListener(v -> finish());
    }

    private void init() {
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);
        btn_back = findViewById(R.id.btn_back);
    }
}