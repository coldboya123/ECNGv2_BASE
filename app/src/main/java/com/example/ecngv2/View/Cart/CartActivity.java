package com.example.ecngv2.View.Cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.ecngv2.Adapter.RCV_Cart_Adapter;
import com.example.ecngv2.Model.Object.Cart;
import com.example.ecngv2.View.Payment.PaymentActivity;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rcv;
    ImageButton btn_close;
    AppCompatButton btn_paymnet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        init();
        List<Cart> cartList = new ArrayList<>();
        getData(cartList);
        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(new RCV_Cart_Adapter(this, cartList));

        btn_close.setOnClickListener(this);
        btn_paymnet.setOnClickListener(this);
    }

    private void init(){
        rcv = findViewById(R.id.rcv_cart);
        btn_close = findViewById(R.id.btn_cart_close);
        btn_paymnet = findViewById(R.id.cart_btn_payment);
    }
    private void getData(List<Cart> list){
        list.add(new Cart(R.drawable.laptop3, "apple_long_shop", "Laptop Dell Latitude 1280", "30.000.000đ"));
        list.add(new Cart(R.drawable.laptop2, "apple_long_shop", "Laptop Dell Latitude 1280", "30.000.000đ"));
        list.add(new Cart(R.drawable.laptop4, "apple_long_shop", "Laptop Dell Latitude 1280", "30.000.000đ"));
        list.add(new Cart(R.drawable.laptop5, "apple_long_shop", "Laptop Dell Latitude 1280", "30.000.000đ"));
        list.add(new Cart(R.drawable.laptop1, "apple_long_shop", "Laptop Dell Latitude 1280", "30.000.000đ"));
        list.add(new Cart(R.drawable.laptop3, "apple_long_shop", "Laptop Dell Latitude 1280", "30.000.000đ"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_cart_close:
                finish();
                break;
            case R.id.cart_btn_payment:
                startActivity(new Intent(CartActivity.this, PaymentActivity.class));
                break;
        }
    }
}