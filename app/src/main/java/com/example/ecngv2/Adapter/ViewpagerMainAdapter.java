package com.example.ecngv2.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ecngv2.View.Category.CategoryFragment;
import com.example.ecngv2.View.Home.HomeFragment;
import com.example.ecngv2.View.Notification.NotificationFragment;
import com.example.ecngv2.View.User.UserFragment;

public class ViewpagerMainAdapter extends FragmentPagerAdapter {
    public ViewpagerMainAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new CategoryFragment();
            case 2:
                return new NotificationFragment();
            case 3:
                return new UserFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
