package com.example.ecngv2.View.Cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ecngv2.Adapter.Handle.HandleRCVCartAdapter;
import com.example.ecngv2.Adapter.RCV_Cart_Adapter;
import com.example.ecngv2.Model.Object.ProductCart;
import com.example.ecngv2.Model.Object.ProductCartItem;
import com.example.ecngv2.View.Payment.PaymentActivity;
import com.example.ecngv2.R;
import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements View.OnClickListener, HandleRCVCartAdapter {

    SwipeRefreshLayout refreshLayout;
    RecyclerView rcv;
    ImageButton btn_close;
    AppCompatButton btn_paymnet;
    TextView txtTotal;
    List<ProductCart> list;
    List<ProductCartItem> cartItems;
    RCV_Cart_Adapter adapter;
    Intent intent;
//    MaterialCheckBox check;

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

        refreshLayout.setOnRefreshListener(() -> refreshLayout.setRefreshing(false));

        getData();
        adapter = new RCV_Cart_Adapter(this, list, this);
        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(adapter);

        txtTotal.setText(String.format("%,d", adapter.getTotalPrice()) + " đ");
        if (adapter.getTotalPrice() == 0) {
            btn_paymnet.setEnabled(false);
            btn_paymnet.setBackgroundColor(getColor(R.color.dark_1));
        }

        btn_close.setOnClickListener(this);
        btn_paymnet.setOnClickListener(this);
    }

    private void init() {
        refreshLayout = findViewById(R.id.refresh_cart);
        rcv = findViewById(R.id.rcv_cart);
        btn_close = findViewById(R.id.btn_cart_close);
        btn_paymnet = findViewById(R.id.cart_btn_payment);
        txtTotal = findViewById(R.id.cart_total);
//        check = findViewById(R.id.cart_checkall);
    }

    private void getData() {
        list = new ArrayList<>();
        cartItems = new ArrayList<>();
        cartItems.add(new ProductCartItem(R.drawable.laptop2, 2, "Laptop Dell Latitude 1280", 30000000, "Đen", false));
        cartItems.add(new ProductCartItem(R.drawable.laptop3, 1, "Laptop Dell Latitude 1280", 30000000, "Xanh", false));
        cartItems.add(new ProductCartItem(R.drawable.laptop5, 1, "Laptop Dell Latitude 1280", 30000000, "Đỏ", false));
        list.add(new ProductCart("apple_long_butterfly", cartItems, false));

        cartItems = new ArrayList<>();
        cartItems.add(new ProductCartItem(R.drawable.dienthoai2, 2, "Laptop Dell Latitude 1280", 30000000, "RAM 12GB", false));
        cartItems.add(new ProductCartItem(R.drawable.dienthoai1, 1, "Laptop Dell Latitude 1280", 30000000, "RAM 12GB", false));
        list.add(new ProductCart("toi_tai_tu", cartItems, false));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cart_close:
                finish();
                break;
            case R.id.cart_btn_payment:
                intent = new Intent(CartActivity.this, PaymentActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void UpdateTotalPrice(int total) {
        txtTotal.setText(String.format("%,d", total) + " đ");
        if (total > 0) {
            btn_paymnet.setBackground(getDrawable(R.drawable.background_radius_primary_color));
            btn_paymnet.setEnabled(true);
        } else {
            btn_paymnet.setBackgroundColor(getColor(R.color.dark_1));
            btn_paymnet.setEnabled(false);
        }
    }
}