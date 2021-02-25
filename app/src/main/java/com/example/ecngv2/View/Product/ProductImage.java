package com.example.ecngv2.View.Product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ecngv2.Adapter.SliderViewProductZoomAdapter;
import com.example.ecngv2.R;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

public class ProductImage extends AppCompatActivity {

    SliderView sliderView;
    ImageButton btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_image);
        init();
        Intent i = getIntent();
        List<Integer> list = (List<Integer>) i.getSerializableExtra("list");
        int pos = i.getIntExtra("position", 0);
        sliderView.setSliderAdapter(new SliderViewProductZoomAdapter(this, list));
        sliderView.setCurrentPagePosition(pos);
        btn_back.setOnClickListener(view -> finish());
    }

    private void init(){
        sliderView = findViewById(R.id.slide_product_zoom);
        btn_back = findViewById(R.id.product_image_back);
    }
}