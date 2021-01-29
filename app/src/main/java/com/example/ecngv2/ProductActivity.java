package com.example.ecngv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ecngv2.Adapter.RCV_Product_Adapter;
import com.example.ecngv2.Adapter.SliderViewPagerAdapter;
import com.example.ecngv2.Model.Product;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ProductActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;
    int[] listImg;
    ConstraintLayout choose_type;
    TextView txtPrice1, btn_plush, btn_minus, txt_number;
    ImageButton btn_closeDialog, btn_back;
    BottomSheetDialog dialog;
    int number;
    RecyclerView rcv;
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
    }

    private void init(){
        viewPager = findViewById(R.id.slide_product);
        listImg = new int[]{R.drawable.laptop1, R.drawable.laptop2, R.drawable.laptop3, R.drawable.laptop4, R.drawable.laptop5};
        choose_type = findViewById(R.id.choose_type);
        btn_back = findViewById(R.id.product_btn_back);
        rcv = findViewById(R.id.rcv_product);
        txtPrice1 = dialog.findViewById(R.id.dialog_price1);
        txtPrice1.setPaintFlags(txtPrice1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        btn_closeDialog = dialog.findViewById(R.id.btn_close_dialog);
        txt_number = dialog.findViewById(R.id.dialog_product_number);
        number = Integer.parseInt(txt_number.getText().toString());
        btn_plush= dialog.findViewById(R.id.dialog_btn_plush);
        btn_minus = dialog.findViewById(R.id.idalog_btnminus);
        btn_closeDialog.setOnClickListener(this);
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
        }
    }
}