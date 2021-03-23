package com.example.ecngv2.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ecngv2.View.Voucher.VoucherActiveFragment;
import com.example.ecngv2.View.Voucher.VoucherInactiveFragment;
import com.example.ecngv2.View.Voucher.VoucherUsedFragment;

public class ViewPagerVoucherAdapter extends FragmentPagerAdapter {
    public ViewPagerVoucherAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new VoucherActiveFragment();
            case 1:
                return new VoucherUsedFragment();
            case 2:
                return new VoucherInactiveFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Còn hiệu lực";
            case 1:
                return "Đã sử dụng";
            case 2:
                return "Hết hiệu lực";
        }
        return null;
    }
}
