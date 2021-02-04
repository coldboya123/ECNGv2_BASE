package com.example.ecngv2.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ecngv2.Shop_Member_Fragment;
import com.example.ecngv2.Shop_Product_Fragment;
import com.example.ecngv2.Shop_Profile_Fragment;
import com.example.ecngv2.Shop_ShopFragment;


public class ViewPager_Shop_Adapter extends FragmentPagerAdapter {
    public ViewPager_Shop_Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Shop_ShopFragment();
            case 1:
                return new Shop_Product_Fragment();
            case 2:
                return new Shop_Member_Fragment();
            case 3:
                return new Shop_Profile_Fragment();
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
                return "Cửa hàng";
            case 1:
                return "Sản phẩm";
            case 2:
                return "Thành viên";
            case 3:
                return "Hồ sơ";
        }
        return null;
    }
}
