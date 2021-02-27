package com.example.ecngv2.View.CateDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecngv2.Adapter.RCV_CateDetail_TradeMark_Adapter;
import com.example.ecngv2.Adapter.SliderViewHomeAdapter;
import com.example.ecngv2.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class CateDetailActivity extends AppCompatActivity {

    Intent intent;
    SliderView sliderView;
    List<Integer> banners;
    RecyclerView rcv_trademark;
    List<Integer> list_trademark_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catedetail);
        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        init();
        intent = getIntent();
        Toast.makeText(this, intent.getIntExtra("position", -1)+"", Toast.LENGTH_SHORT).show();

        sliderView.setSliderAdapter(new SliderViewHomeAdapter(this, banners));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();

        rcv_trademark.setLayoutManager(new GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false));
        rcv_trademark.setAdapter(new RCV_CateDetail_TradeMark_Adapter(this, list_trademark_img));
    }

    private void init(){
        sliderView = findViewById(R.id.slide_banner);
        banners = new ArrayList<>();
        banners.add(R.drawable.slider_1);
        banners.add(R.drawable.slider_2);
        banners.add(R.drawable.slider_3);
        banners.add(R.drawable.slider_4);
        banners.add(R.drawable.slider_5);

        rcv_trademark = findViewById(R.id.catedetail_rcv_trademark);
        list_trademark_img = new ArrayList<>();
        list_trademark_img.add(R.drawable.logo_asus);
        list_trademark_img.add(R.drawable.logo_lg);
        list_trademark_img.add(R.drawable.logo_mac);
        list_trademark_img.add(R.drawable.logo_lenovo);
        list_trademark_img.add(R.drawable.logo_samsung);
        list_trademark_img.add(R.drawable.logo_brooks_brothers);
        list_trademark_img.add(R.drawable.logo_calvin_klein);
        list_trademark_img.add(R.drawable.logo_j_crew);
        list_trademark_img.add(R.drawable.logo_h_m);
        list_trademark_img.add(R.drawable.logo_guess);
        list_trademark_img.add(R.drawable.logo_ralph_lauren);
    }
}