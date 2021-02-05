package com.example.ecngv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ecngv2.Adapter.RCV_Payment_Adapter;
import com.example.ecngv2.Model.PaymentProduct;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rcv;
    EditText voucher;
    ImageButton btn_close, edit_address_1, edit_address_2, hide_edit_address_dialog;
    TextView btn_change_address, btn_change_shipping, btn_change_payment;
    List<PaymentProduct> list;
    BottomSheetDialog address_dialog, shipping_dialog, payment_dialog, edit_address_dialog;
    ImageButton hide_address_dialog, hide_shipping_dialog, hide_payment_dialog;
    RadioButton radio_address_1, radio_address_2, radio_shipping_1, radio_shipping_2, radio_shipping_3, radio_shipping_checked;
    ColorStateList colorStateList;
    LinearLayout payment_item_1, payment_item_2, payment_item_3, payment_item_selected;
    Spinner spinner_tinh, spinner_huyen, spinner_xa;
    SQLiteDatabase db;
    String[] tinh, huyen, xa;
    AppCompatButton btn_apply_edit_address;
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
        payment_dialog = new BottomSheetDialog(this);
        payment_dialog.setContentView(R.layout.dialog_choose_payment);
        edit_address_dialog = new BottomSheetDialog(this);
        edit_address_dialog.setContentView(R.layout.dialog_edit_address);
        init();
        loadData(list);
        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(new RCV_Payment_Adapter(this, list));
        btn_close.setOnClickListener(this);

        btn_change_address.setOnClickListener(this);
        hide_address_dialog.setOnClickListener(this);
        radio_address_1.setOnClickListener(this);
        radio_address_2.setOnClickListener(this);
        radio_address_1.setButtonTintList(colorStateList);
        radio_address_2.setButtonTintList(colorStateList);
        edit_address_1.setOnClickListener(this);
        edit_address_2.setOnClickListener(this);
        hide_edit_address_dialog.setOnClickListener(this);
        btn_apply_edit_address.setOnClickListener(this);

        btn_change_shipping.setOnClickListener(this);
        hide_shipping_dialog.setOnClickListener(this);
        radio_shipping_1.setOnClickListener(this);
        radio_shipping_2.setOnClickListener(this);
        radio_shipping_3.setOnClickListener(this);
        radio_shipping_1.setButtonTintList(colorStateList);
        radio_shipping_2.setButtonTintList(colorStateList);
        radio_shipping_3.setButtonTintList(colorStateList);

        btn_change_payment.setOnClickListener(this);
        hide_payment_dialog.setOnClickListener(this);
        payment_item_1.setOnClickListener(this);
        payment_item_2.setOnClickListener(this);
        payment_item_3.setOnClickListener(this);
        payment_item_selected.setBackground(getDrawable(R.drawable.background_radius_dark2_selected));

        LoadData();
        ArrayAdapter adapterTinh = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tinh);
        spinner_tinh.setAdapter(adapterTinh);
        ArrayAdapter adapterHuyen = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, huyen);
        spinner_huyen.setAdapter(adapterHuyen);
        ArrayAdapter adapterXa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, xa);
        spinner_xa.setAdapter(adapterXa);
    }

    private void loadData(List<PaymentProduct> list){
        list.add(new PaymentProduct(R.drawable.laptop1, 2, "Điện thoại Ipad 12 pro 2020", "10.000.000 đ"));
        list.add(new PaymentProduct(R.drawable.chungcu, 1, "Biệt thự siêu to khổng lồ", "10.000.000.000 đ"));
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
        edit_address_1 = address_dialog.findViewById(R.id.radio_address1_edit);
        edit_address_2 = address_dialog.findViewById(R.id.radio_address2_edit);
        hide_edit_address_dialog = edit_address_dialog.findViewById(R.id.edit_address_btn_close);
        spinner_tinh = edit_address_dialog.findViewById(R.id.spinner_tinh);
        spinner_huyen = edit_address_dialog.findViewById(R.id.spinner_huyen);
        spinner_xa = edit_address_dialog.findViewById(R.id.spinner_xa);
        btn_apply_edit_address = edit_address_dialog.findViewById(R.id.edit_address_btn_apply);
        btn_change_shipping = findViewById(R.id.payment_txtchangeship);
        hide_shipping_dialog = shipping_dialog.findViewById(R.id.dialog_chooseshipping_hide);
        radio_shipping_1 = shipping_dialog.findViewById(R.id.radio_btn_shipping1);
        radio_shipping_2 = shipping_dialog.findViewById(R.id.radio_btn_shipping2);
        radio_shipping_3 = shipping_dialog.findViewById(R.id.radio_btn_shipping3);
        radio_shipping_checked = radio_shipping_1;
        radio_shipping_checked.setChecked(true);
        btn_change_payment = findViewById(R.id.payment_txtchangepayment);
        hide_payment_dialog = payment_dialog.findViewById(R.id.dialog_choosepayment_hide);
        payment_item_1 = payment_dialog.findViewById(R.id.payment_choosepayment_item1);
        payment_item_2 = payment_dialog.findViewById(R.id.payment_choosepayment_item2);
        payment_item_3 = payment_dialog.findViewById(R.id.payment_choosepayment_item3);
        payment_item_selected = payment_item_1;
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
            case R.id.radio_address1_edit:
            case R.id.radio_address2_edit:
                edit_address_dialog.show();
                break;
            case R.id.edit_address_btn_apply:
            case R.id.edit_address_btn_close:
                edit_address_dialog.hide();
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
            case R.id.payment_txtchangepayment:
                payment_dialog.show();
                break;
            case R.id.dialog_choosepayment_hide:
                payment_dialog.hide();
                break;
            case R.id.payment_choosepayment_item1:
                payment_item_1.setBackground(getDrawable(R.drawable.background_radius_dark2_selected));
                payment_item_selected.setBackground(getDrawable(R.drawable.backgroung_radius_dark_2));
                payment_item_selected = payment_item_1;
                break;
            case R.id.payment_choosepayment_item2:
                payment_item_2.setBackground(getDrawable(R.drawable.background_radius_dark2_selected));
                payment_item_selected.setBackground(getDrawable(R.drawable.backgroung_radius_dark_2));
                payment_item_selected = payment_item_2;
                break;
            case R.id.payment_choosepayment_item3:
                payment_item_3.setBackground(getDrawable(R.drawable.background_radius_dark2_selected));
                payment_item_selected.setBackground(getDrawable(R.drawable.backgroung_radius_dark_2));
                payment_item_selected = payment_item_3;
                break;
        }
    }

    private void LoadData(){
        tinh = new String[]{"Chọn Tỉnh/Thành phố", "TP.Hồ Chí Minh", "Hà Nội", "Cần Thơ", "Đà Nẵng", "Ninh Thuận", "Bạc Liêu", "..."};
        huyen = new String[]{"Chọn Quận/Huyện", "Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8"};
        xa = new String[]{"Chọn Phường/Xã", "Phường 1", "Phường 2", "Phường 3", "Phường 4", "Phường 5", "Phường 6", "Phường 7"};
    }
}