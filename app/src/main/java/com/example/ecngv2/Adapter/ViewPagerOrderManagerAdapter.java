package com.example.ecngv2.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ecngv2.View.OrderManager.OrderPickup.OrderPickupFragment;
import com.example.ecngv2.View.OrderManager.OrderConfirm.OrderConfirmFragment;
import com.example.ecngv2.View.OrderManager.OrderDelivered.OrderDeliveredFragment;
import com.example.ecngv2.View.OrderManager.OrderCancel.OrderCancelFragment;
import com.example.ecngv2.View.OrderManager.OrderDelivering.OrderDeliveringFragment;
import com.example.ecngv2.View.OrderManager.OrderReturn.OrderReturnFragment;

public class ViewPagerOrderManagerAdapter extends FragmentPagerAdapter {
    public ViewPagerOrderManagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new OrderConfirmFragment();
            case 1:
                return new OrderPickupFragment();
            case 2:
                return new OrderDeliveringFragment();
            case 3:
                return new OrderDeliveredFragment();
            case 4:
                return new OrderCancelFragment();
            case 5:
                return new OrderReturnFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Chờ xác nhận";
            case 1:
                return "Chờ lấy hàng";
            case 2:
                return "Đang giao";
            case 3:
                return "Đã giao";
            case 4:
                return "Đã hủy";
            case 5:
                return "Trả hàng";
        }
        return null;
    }
}
