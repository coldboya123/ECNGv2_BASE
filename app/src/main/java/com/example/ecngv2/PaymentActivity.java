package com.example.ecngv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.ecngv2.Adapter.RCV_Payment_Adapter;
import com.example.ecngv2.Model.PaymentProduct;

import java.util.ArrayList;
import java.util.List;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rcv;
    EditText voucher;
    ImageButton btn_close;
    List<PaymentProduct> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);
        init();
        loadData(list);
        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(new RCV_Payment_Adapter(this, list));
        btn_close.setOnClickListener(this);
    }

    private void loadData(List<PaymentProduct> list){
        list.add(new PaymentProduct(R.drawable.laptop1, 2, "Điện thoại Ipad 12 pro 2020", "10.000.000 đ"));
        list.add(new PaymentProduct(R.drawable.category_1, 1, "Em người yêu", "10.000.000.000 đ"));
        list.add(new PaymentProduct(R.drawable.laptop1, 2, "Điện thoại Ipad 12 pro 2020", "10.000.000 đ"));
        list.add(new PaymentProduct(R.drawable.laptop1, 2, "Điện thoại Ipad 12 pro 2020", "10.000.000 đ"));
        list.add(new PaymentProduct(R.drawable.laptop1, 2, "Điện thoại Ipad 12 pro 2020", "10.000.000 đ"));
    }

    private void init(){
        rcv = findViewById(R.id.rcv_payment);
        voucher = findViewById(R.id.payment_edit_voucher);
        btn_close = findViewById(R.id.payment_btn_close);
        list = new ArrayList<>();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.payment_btn_close:
                finish();
                break;
        }
    }
}