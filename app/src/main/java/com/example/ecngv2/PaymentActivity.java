package com.example.ecngv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ecngv2.Adapter.RCV_Payment_Adapter;
import com.example.ecngv2.Model.PaymentProduct;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rcv;
    EditText voucher;
    ImageButton btn_close;
    TextView btn_change_address, btn_change_shipping;
    List<PaymentProduct> list;
    BottomSheetDialog address_dialog, shipping_dialog;
    ImageButton hide_address_dialog, hide_shipping_dialog;
    RadioButton radio_address_1, radio_address_2, radio_shipping_1, radio_shipping_2, radio_shipping_3, radio_shipping_checked;
    ColorStateList colorStateList;
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
        address_dialog = new BottomSheetDialog(this);
        address_dialog.setContentView(R.layout.dialog_choose_address);
        shipping_dialog = new BottomSheetDialog(this);
        shipping_dialog.setContentView(R.layout.dialog_choose_shipping);
        init();
        loadData(list);
        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(new RCV_Payment_Adapter(this, list));
        btn_change_address.setOnClickListener(this);
        btn_close.setOnClickListener(this);
        hide_address_dialog.setOnClickListener(this);
        radio_address_1.setOnClickListener(this);
        radio_address_2.setOnClickListener(this);
        radio_address_1.setButtonTintList(colorStateList);
        radio_address_2.setButtonTintList(colorStateList);
        btn_change_shipping.setOnClickListener(this);
        hide_shipping_dialog.setOnClickListener(this);
        radio_shipping_1.setOnClickListener(this);
        radio_shipping_2.setOnClickListener(this);
        radio_shipping_3.setOnClickListener(this);
        radio_shipping_1.setButtonTintList(colorStateList);
        radio_shipping_2.setButtonTintList(colorStateList);
        radio_shipping_3.setButtonTintList(colorStateList);
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
        btn_change_address = findViewById(R.id.payment_txtchangeadd);
        hide_address_dialog = address_dialog.findViewById(R.id.dialog_chooseaddress_hide);
        radio_address_1 = address_dialog.findViewById(R.id.radio_btn_address1);
        radio_address_2 = address_dialog.findViewById(R.id.radio_btn_address2);
        btn_change_shipping = findViewById(R.id.payment_txtchangeship);
        hide_shipping_dialog = shipping_dialog.findViewById(R.id.dialog_chooseshipping_hide);
        radio_shipping_1 = shipping_dialog.findViewById(R.id.radio_btn_shipping1);
        radio_shipping_2 = shipping_dialog.findViewById(R.id.radio_btn_shipping2);
        radio_shipping_3 = shipping_dialog.findViewById(R.id.radio_btn_shipping3);
        radio_shipping_checked = radio_shipping_1;
        radio_shipping_checked.setChecked(true);
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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.payment_btn_close:
                finish();
                break;
            case R.id.payment_txtchangeadd:
                address_dialog.show();
                break;
            case R.id.dialog_chooseaddress_hide:
                address_dialog.hide();
                break;
            case R.id.radio_btn_address1:
                radio_address_1.setChecked(true);
                radio_address_2.setChecked(false);
                break;
            case R.id.radio_btn_address2:
                radio_address_2.setChecked(true);
                radio_address_1.setChecked(false);
                break;
            case R.id.payment_txtchangeship:
                shipping_dialog.show();
                break;
            case R.id.dialog_chooseshipping_hide:
                shipping_dialog.hide();
                break;
            case R.id.radio_btn_shipping1:
                radio_shipping_1.setChecked(true);
                radio_shipping_checked.setChecked(false);
                radio_shipping_checked = radio_shipping_1;
                break;
            case R.id.radio_btn_shipping2:
                radio_shipping_2.setChecked(true);
                radio_shipping_checked.setChecked(false);
                radio_shipping_checked = radio_shipping_2;
                break;
            case R.id.radio_btn_shipping3:
                radio_shipping_3.setChecked(true);
                radio_shipping_checked.setChecked(false);
                radio_shipping_checked = radio_shipping_3;
                break;
        }
    }

}