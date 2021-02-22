package com.example.ecngv2.View.Product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ecngv2.Adapter.RCV_Product_Adapter;
import com.example.ecngv2.Adapter.SliderViewPagerAdapter;
import com.example.ecngv2.R;
import com.example.ecngv2.View.Shop.ShopActivity;
import com.example.ecngv2.View.Cart.CartActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ProductActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;
    int[] listImg;
    ConstraintLayout choose_type;
    TextView txtPrice1, btn_plush, btn_minus, txt_number, color1, color2, color3, color4, color5, color_selected, viewShop;
    ImageButton btn_closeDialog, btn_back, btn_cart;
    BottomSheetDialog dialog;
    int number;
    RecyclerView rcv;
    AppCompatButton btn_buynow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        dialog = new BottomSheetDialog(this);
        dialog.setContentView(R.layout.dialog_choose_type);
        init();
        choose_type.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_cart.setOnClickListener(this);
        SliderViewPagerAdapter sliderAdapter = new SliderViewPagerAdapter(this, listImg);
        viewPager.setAdapter(sliderAdapter);
        if (number == 1){
            btn_minus.setEnabled(false);
        }
        btn_plush.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        RCV_Product_Adapter adapter = new RCV_Product_Adapter(this);
        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(adapter);
        color1.setOnClickListener(this);
        color2.setOnClickListener(this);
        color3.setOnClickListener(this);
        color4.setOnClickListener(this);
        color5.setOnClickListener(this);
        btn_buynow.setOnClickListener(this);
        viewShop.setOnClickListener(this);
    }

    private void init(){
        viewPager = findViewById(R.id.slide_product);
        listImg = new int[]{R.drawable.laptop1, R.drawable.laptop2, R.drawable.laptop3, R.drawable.laptop4, R.drawable.laptop5, R.drawable.laptop6, R.drawable.laptop7};
        choose_type = findViewById(R.id.choose_type);
        btn_back = findViewById(R.id.product_btn_back);
        btn_cart = findViewById(R.id.product_btn_cart);
        rcv = findViewById(R.id.rcv_product);
        txtPrice1 = dialog.findViewById(R.id.dialog_price1);
        txtPrice1.setPaintFlags(txtPrice1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        btn_closeDialog = dialog.findViewById(R.id.btn_close_dialog);
        txt_number = dialog.findViewById(R.id.dialog_product_number);
        number = Integer.parseInt(txt_number.getText().toString());
        btn_plush= dialog.findViewById(R.id.dialog_btn_plush);
        btn_minus = dialog.findViewById(R.id.idalog_btnminus);
        btn_closeDialog.setOnClickListener(this);
        color1 = dialog.findViewById(R.id.dialog_color1);
        color2 = dialog.findViewById(R.id.dialog_color2);
        color3 = dialog.findViewById(R.id.dialog_color3);
        color4 = dialog.findViewById(R.id.dialog_color4);
        color5 = dialog.findViewById(R.id.dialog_color5);
        color_selected = color1;
        btn_buynow = dialog.findViewById(R.id.dialog_product_buynow);
        viewShop = findViewById(R.id.product_viewshop);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.choose_type:
                dialog.show();
                break;
            case R.id.product_btn_back:
                finish();
                break;
            case R.id.product_btn_cart:
            case R.id.dialog_product_buynow:
                startActivity(new Intent(ProductActivity.this, CartActivity.class));
                break;
            case R.id.dialog_btn_plush:
                if (number > 1){
                    btn_minus.setEnabled(true);
                }
                txt_number.setText(number+1+"");
                number++;
                break;
            case R.id.idalog_btnminus:
                if (number == 1){
                    btn_minus.setEnabled(false);
                }else {
                    txt_number.setText(number-1+"");
                    number--;
                }
                break;
            case R.id.btn_close_dialog:
                dialog.dismiss();
                break;
            case R.id.dialog_color1:
                SetColorSelected(color_selected, color1);
                color_selected = color1;
                break;
            case R.id.dialog_color2:
                SetColorSelected(color_selected, color2);
                color_selected = color2;
                break;
            case R.id.dialog_color3:
                SetColorSelected(color_selected, color3);
                color_selected = color3;
                break;
            case R.id.dialog_color4:
                SetColorSelected(color_selected, color4);
                color_selected = color4;
                break;
            case R.id.dialog_color5:
                SetColorSelected(color_selected, color5);
                color_selected = color5;
                break;
            case R.id.product_viewshop:
                startActivity(new Intent(ProductActivity.this, ShopActivity.class));
                break;
        }
    }

    private void SetColorSelected(TextView temp, TextView selected){
        temp.setBackground(getDrawable(R.drawable.border_dark));
        temp.setTextColor(getColor(R.color.black));
        selected.setBackground(getDrawable(R.drawable.border_primary_color));
        selected.setTextColor(getColor(R.color.primary_color));
    }
}