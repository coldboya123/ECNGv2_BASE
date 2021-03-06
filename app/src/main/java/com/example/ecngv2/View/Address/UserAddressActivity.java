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
        list.add(new UserAddress("Nguy???n ?????c Huy", "0327347087", "99A C???ng H??a, Ph?????ng 4, Qu???n T??n B??nh, Th??nh ph??? H??? Ch?? Minh", true));
        list.add(new UserAddress("V?? H??a T???i", "0327347087", "99A C???ng H??a, Ph?????ng 4, Qu???n T??n B??nh, Th??nh ph??? H??? Ch?? Minh", false));
        list.add(new UserAddress("H??? Nguy???n Thi??n Long", "0327347087", "12 Tr???nh ????nh Th???o, Ph?????ng 4, Qu???n T??n T??n Ph??, Th??nh ph??? H??? Ch?? Minh", false));
        list.add(new UserAddress("S???p B??nh", "0327347087", "99A C???ng H??a, Ph?????ng 4, Qu???n T??n B??nh, Th??nh ph??? H??? Ch?? Minh", false));
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