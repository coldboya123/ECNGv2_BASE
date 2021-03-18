package com.example.ecngv2.View.Payment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ecngv2.R;
import com.example.ecngv2.View.MainActivity.MainActivity;

public class PaymentSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}