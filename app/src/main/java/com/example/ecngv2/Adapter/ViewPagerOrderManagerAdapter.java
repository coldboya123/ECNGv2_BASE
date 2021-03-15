package com.example.ecngv2.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ecngv2.View.OrderManager.OrderCholayhangFragment;
import com.example.ecngv2.View.OrderManager.OrderChoxacnhanFragment;
import com.example.ecngv2.View.OrderManager.OrderDagiaoFragment;
import com.example.ecngv2.View.OrderManager.OrderDahuyFragment;
import com.example.ecngv2.View.OrderManager.OrderDanggiaoFragment;
import com.example.ecngv2.View.OrderManager.OrderTrahangFragment;

public class ViewPagerOrderManagerAdapter extends FragmentPagerAdapter {
    public ViewPagerOrderManagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new OrderChoxacnhanFragment();
            case 1:
                return new OrderCholayhangFragment();
            case 2:
                return new OrderDanggiaoFragment();
            case 3:
                return new OrderDagiaoFragment();
            case 4:
                return new OrderDahuyFragment();
            case 5:
                return new OrderTrahangFragment();
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
