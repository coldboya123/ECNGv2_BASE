package com.example.ecngv2.View.OrderManager.OrderDetail;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Adapter.RCV_OrderDetail_Adapter;
import com.example.ecngv2.Model.Object.ProductCart;
import com.example.ecngv2.Model.Object.ProductCartItem;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_back;
    RecyclerView rcv;
    List<ProductCart> list;
    List<ProductCartItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        init();

        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(new RCV_OrderDetail_Adapter(this, list));

        btn_back.setOnClickListener(this);
    }

    private void init() {
        btn_back = findViewById(R.id.orderdetail_btn_back);
        rcv = findViewById(R.id.rcv_orderdetail);

        list = new ArrayList<>();

        itemList = new ArrayList<>();
        itemList.add(new ProductCartItem(R.drawable.laptop2, 2, "Laptop Dell Latitude 1280", 30000000, "Đen", true));
        itemList.add(new ProductCartItem(R.drawable.laptop5, 2, "Laptop Dell Latitude 1280", 30000000, "Đen", true));
        list.add(new ProductCart("apple_long_butterfly", itemList, true));

        itemList = new ArrayList<>();
        itemList.add(new ProductCartItem(R.drawable.dienthoai1, 2, "Laptop Dell Latitude 1280", 30000000, "Đen", true));
        list.add(new ProductCart("toi_tai_tu", itemList, true));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.orderdetail_btn_back:
                finish();
                break;
        }
    }
}