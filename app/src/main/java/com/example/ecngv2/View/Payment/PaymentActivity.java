package com.example.ecngv2.View.Payment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ecngv2.Adapter.Handle.HandleRCVPaymentAdapter;
import com.example.ecngv2.Adapter.RCV_Payment_Adapter;
import com.example.ecngv2.Model.Object.ProductCartItem;
import com.example.ecngv2.Model.Object.ProductPayment;
import com.example.ecngv2.R;
import com.example.ecngv2.View.Address.UserAddressActivity;

import java.util.ArrayList;
import java.util.List;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener, HandleRCVPaymentAdapter {

    RecyclerView rcv;
    EditText voucher;
    ImageButton btn_close;
    TextView btn_change_address, total;
    List<ProductPayment> list;
    List<ProductCartItem> cartItems;
    ColorStateList colorStateList;
    RCV_Payment_Adapter adapter;
    ConstraintLayout payment_method_1, payment_method_2;
    RadioButton radio_btn_method_1, radio_btn_method_2, radio_btn_method_checked;
    AppCompatButton btn_payment;
    Intent intent;

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
        loadData();
        adapter = new RCV_Payment_Adapter(this, list, this);
        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(adapter);

        total.setText(String.format("%,d", getTotal(list))+" đ");

        btn_close.setOnClickListener(this);
        btn_change_address.setOnClickListener(this);
        payment_method_1.setOnClickListener(this);
        payment_method_2.setOnClickListener(this);
        btn_payment.setOnClickListener(this);
    }

    private int getTotal(List<ProductPayment> list){
        int total = 0;
        for (int i=0; i<list.size(); i++){
            for (int j=0; j<list.get(i).getList().size(); j++){
                total += (list.get(i).getList().get(j).getPrice() * list.get(i).getList().get(j).getNum());
            }
            total += list.get(i).getShipping();
        }
        return total;
    }

    private void loadData(){
        list = new ArrayList<>();

        cartItems = new ArrayList<>();
        cartItems.add(new ProductCartItem(R.drawable.laptop2, 2, "Laptop Dell Latitude 1280", 30000000, "Đen", true));
        cartItems.add(new ProductCartItem(R.drawable.laptop3, 1, "Laptop Dell Latitude 1280", 30000000, "Xanh", true));
        cartItems.add(new ProductCartItem(R.drawable.laptop5, 1, "Laptop Dell Latitude 1280", 30000000, "Đỏ", true));
        list.add(new ProductPayment("apple_long_butterfly", cartItems, 0));

        cartItems = new ArrayList<>();
        cartItems.add(new ProductCartItem(R.drawable.dienthoai2, 2, "Laptop Dell Latitude 1280", 30000000, "RAM 12GB", true));
        cartItems.add(new ProductCartItem(R.drawable.dienthoai1, 1, "Laptop Dell Latitude 1280", 30000000, "RAM 12GB", true));
        list.add(new ProductPayment("toi_tai_tu", cartItems, 0));
    }

    private void init(){
        total = findViewById(R.id.payment_total);
        rcv = findViewById(R.id.rcv_payment);
        btn_close = findViewById(R.id.payment_btn_close);
        list = new ArrayList<>();
        btn_change_address = findViewById(R.id.payment_txtchangeadd);

        payment_method_1 = findViewById(R.id.payment_method_1);
        payment_method_2 = findViewById(R.id.payment_method_2);
        radio_btn_method_1 = findViewById(R.id.radio_payment_method_1);
        radio_btn_method_2 = findViewById(R.id.radio_payment_method_2);
        radio_btn_method_checked = radio_btn_method_1;

        colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{

                        getColor(R.color.dark)
                        , getColor(R.color.primary_color),
                }
        );
        radio_btn_method_1.setButtonTintList(colorStateList);
        radio_btn_method_2.setButtonTintList(colorStateList);

        btn_payment = findViewById(R.id.payment_btn_payment);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.payment_btn_close:
                finish();
                break;
            case R.id.payment_txtchangeadd:
                intent = new Intent(PaymentActivity.this, UserAddressActivity.class);
                startActivity(intent);
                break;
            case R.id.payment_method_1:
                radio_btn_method_checked.setChecked(false);
                radio_btn_method_1.setChecked(true);
                radio_btn_method_checked = radio_btn_method_1;
                break;
            case R.id.payment_method_2:
                radio_btn_method_checked.setChecked(false);
                radio_btn_method_2.setChecked(true);
                radio_btn_method_checked = radio_btn_method_2;
                break;
            case R.id.payment_btn_payment:
                intent = new Intent(PaymentActivity.this, PaymentSuccessActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void updateTotal() {
        total.setText(String.format("%,d", getTotal(list))+" đ");
    }
}