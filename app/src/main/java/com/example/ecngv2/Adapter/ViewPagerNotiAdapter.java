package com.example.ecngv2.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ecngv2.View.Notification.NotiHomeFragment;
import com.example.ecngv2.View.Notification.NotiOrderFragment;
import com.example.ecngv2.View.Notification.NotiProductFragment;
import com.example.ecngv2.View.Notification.NotiSecureFragment;

public class ViewPagerNotiAdapter extends FragmentPagerAdapter {
    public ViewPagerNotiAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NotiHomeFragment();
            case 1:
                return new NotiOrderFragment();
            case 2:
                return new NotiProductFragment();
            case 3:
                return new NotiSecureFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "ECNG";
            case 1:
                return "Đơn hàng";
            case 2:
                return "Sản phẩm";
            case 3:
                return "Bảo mật";
        }
        return null;
    }

}
