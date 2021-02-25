package com.example.ecngv2.View.Product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ecngv2.Adapter.RCV_Product_Adapter;
import com.example.ecngv2.Adapter.SliderViewProductAdapter;
import com.example.ecngv2.R;
import com.example.ecngv2.View.Shop.ShopActivity;
import com.example.ecngv2.View.Cart.CartActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity implements View.OnClickListener {

    AlertDialog alertDialog;
    List<Integer> listImg;
    ConstraintLayout choose_type;
    TextView txtPrice1, btn_plush, btn_minus, txt_number, color1, color2, color3, color4, color5, color_selected, viewShop;
    ImageButton btn_closeDialog, btn_back, btn_cart;
    BottomSheetDialog dialog;
    int number;
    RecyclerView rcv;
    AppCompatButton btn_buynow, btn_addtocart;
    SliderView sliderView;
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

        sliderView.setSliderAdapter(new SliderViewProductAdapter(this, listImg));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

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
        btn_addtocart.setOnClickListener(this);

        viewShop.setOnClickListener(this);
    }


    private void init(){
        sliderView = findViewById(R.id.slide_product);
        listImg = new ArrayList<>();
        listImg.add(R.drawable.laptop1);
        listImg.add(R.drawable.laptop2);
        listImg.add(R.drawable.laptop3);
        listImg.add(R.drawable.laptop4);
        listImg.add(R.drawable.laptop5);
        listImg.add(R.drawable.laptop6);

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
        btn_addtocart = dialog.findViewById(R.id.dialog_product_addtocart);

        viewShop = findViewById(R.id.product_viewshop);
    }

    @SuppressLint("NonConstantResourceId")
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
            case R.id.dialog_product_addtocart:
                dialog.hide();
//                new AlertDialog.Builder(this)
//                        .setMessage("Đã thêm vào giỏ hàng")
//                        .show();
//                Dialog d = new Dialog(this);
//                d.setContentView(R.layout.dialog_addtocart_layout);
//                Window window = d.getWindow();
//                window.getAttributes().windowAnimations = R.style.DialogAnimation;
//                WindowManager.LayoutParams wlp = window.getAttributes();
//                wlp.gravity = Gravity.TOP;
//                wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
//                window.setAttributes(wlp);
//                d.show();
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
                View layoutView = getLayoutInflater().inflate(R.layout.dialog_addtocart_layout, null);
                dialogBuilder.setView(layoutView);
                alertDialog = dialogBuilder.create();
                Window window = alertDialog.getWindow();
                window.getAttributes().windowAnimations = R.style.DialogAnimation;
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                WindowManager.LayoutParams wlp = window.getAttributes();
                wlp.gravity = Gravity.TOP|Gravity.CENTER;
                wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                window.setAttributes(wlp);
                alertDialog.show();
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