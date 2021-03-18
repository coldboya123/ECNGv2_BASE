package com.example.ecngv2.View.Payment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ecngv2.R;
import com.example.ecngv2.View.MainActivity.MainActivity;
import com.example.ecngv2.View.OrderManager.OrderManagerActivity;

public class PaymentSuccessActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);
        new Thread(() -> {
            try{
                Thread.sleep(3000);
            } catch (Exception e){

            }finally {
                intent = new Intent(getBaseContext(), OrderManagerActivity.class);
                startActivity(intent);
                finish();
            }
        }).start();
    }

}