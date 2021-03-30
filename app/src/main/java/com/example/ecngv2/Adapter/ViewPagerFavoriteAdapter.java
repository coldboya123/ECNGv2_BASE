package com.example.ecngv2.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ecngv2.View.Favorite.FavProductFragment;
import com.example.ecngv2.View.Favorite.FavShopFragment;
import com.example.ecngv2.View.Favorite.FullscreenFragment;

public class ViewPagerFavoriteAdapter extends FragmentPagerAdapter {
    public ViewPagerFavoriteAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FavProductFragment();
            case 1:
                return new FavShopFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Sản phẩm";
            case 1:
                return "Shop theo dõi";
        }
        return null;
    }
}
