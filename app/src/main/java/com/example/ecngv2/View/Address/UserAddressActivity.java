package com.example.ecngv2.View.Address;

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
import android.widget.Button;

import com.example.ecngv2.Adapter.RCV_UserAddress_Adapter;
import com.example.ecngv2.Model.Object.UserAddress;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class UserAddressActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_back;
    RecyclerView rcv;
    List<UserAddress> list;
    AppCompatButton btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_address);

        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        init();
        loadData();

        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(new RCV_UserAddress_Adapter(this, list));

        btn_back.setOnClickListener(this);
        btn_add.setOnClickListener(this);
    }

    private void init(){
        rcv = findViewById(R.id.user_address_rcv);
        btn_back = findViewById(R.id.user_address_btn_back);
        btn_add = findViewById(R.id.user_address_btn_add);
    }

    private void loadData(){
        list = new ArrayList<>();
        list.add(new UserAddress("Nguyễn Đức Huy", "0327347087", "99A Cộng Hòa, Phường 4, Quận Tân Bình, Thành phố Hồ Chí Minh", true));
        list.add(new UserAddress("Võ Hòa Tới", "0327347087", "99A Cộng Hòa, Phường 4, Quận Tân Bình, Thành phố Hồ Chí Minh", false));
        list.add(new UserAddress("Hồ Nguyễn Thiên Long", "0327347087", "12 Trịnh Đình Thảo, Phường 4, Quận Tân Tân Phú, Thành phố Hồ Chí Minh", false));
        list.add(new UserAddress("Sếp Bình", "0327347087", "99A Cộng Hòa, Phường 4, Quận Tân Bình, Thành phố Hồ Chí Minh", false));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_address_btn_back:
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                break;
            case R.id.user_address_btn_add:
                startActivity(new Intent(UserAddressActivity.this, AddUserAddressActivity.class));
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;
        }
    }
}