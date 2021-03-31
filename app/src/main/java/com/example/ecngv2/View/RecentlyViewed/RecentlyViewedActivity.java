package com.example.ecngv2.View.RecentlyViewed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.ecngv2.Adapter.RCV_FavProduct_Adapter;
import com.example.ecngv2.Model.Object.FavProduct;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class RecentlyViewedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<FavProduct> list;
    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R .layout.activity_recently_viewed);
        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        init();

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(new RCV_FavProduct_Adapter(this, list));

        btn_back.setOnClickListener(v -> finish());

    }

    private void init() {
        recyclerView = findViewById(R.id.rcv);
        btn_back = findViewById(R.id.btn_back);


        list = new ArrayList<>();
        list.add(new FavProduct(R.drawable.laptop1, "Jack gộp audio và mic 3.5mm | Jack gộpJack go audio và mic3 tai nghe 3.5 (Trắng)", 20000000, "apple_long_butterfly", R.drawable.avatar_user));
        list.add(new FavProduct(R.drawable.laptop2, "Jack gộp audio và mic 3.5mm | Jack gộpJack go audio và mic3 tai nghe 3.5 (Trắng)", 20000000, "apple_long_butterfly", R.drawable.avatar_user));
        list.add(new FavProduct(R.drawable.laptop3, "Jack gộp audio và mic 3.5mm | Jack gộpJack go audio và mic3 tai nghe 3.5 (Trắng)", 20000000, "apple_long_butterfly", R.drawable.avatar_user));
        list.add(new FavProduct(R.drawable.laptop4, "Jack gộp audio và mic 3.5mm | Jack gộpJack go audio và mic3 tai nghe 3.5 (Trắng)", 20000000, "apple_long_butterfly", R.drawable.avatar_user));
        list.add(new FavProduct(R.drawable.laptop5, "Jack gộp audio và mic 3.5mm | Jack gộpJack go audio và mic3 tai nghe 3.5 (Trắng)", 20000000, "apple_long_butterfly", R.drawable.avatar_user));
        list.add(new FavProduct(R.drawable.laptop6, "Jack gộp audio và mic 3.5mm | Jack gộpJack go audio và mic3 tai nghe 3.5 (Trắng)", 20000000, "apple_long_butterfly", R.drawable.avatar_user));

    }
}