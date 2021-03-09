package com.example.ecngv2.View.Notification;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.ecngv2.Adapter.ViewPagerNotiAdapter;
import com.example.ecngv2.R;
import com.example.ecngv2.customListview;
import com.google.android.material.tabs.TabLayout;


public class NotificationFragment extends Fragment {

    SwipeRefreshLayout refreshLayout;
    ViewPager viewPager;
    TabLayout tabLayout;

    public NotificationFragment() {
        // Required empty public constructor
    }
    customListview listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_noti, container, false);

        init(v);

        int[] icons = {R.drawable.ic_home_primary, R.drawable.ic_order_noti, R.drawable.ic_new_product, R.drawable.ic_secure};
        viewPager.setAdapter(new ViewPagerNotiAdapter(getChildFragmentManager()));
        viewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewPager);
        for (int i=0; i<tabLayout.getTabCount(); i++){
            tabLayout.getTabAt(i).setIcon(icons[i]);
        }

        refreshLayout.setOnRefreshListener(() -> refreshLayout.setRefreshing(false));
        return v;
    }

    private void init(View v){
        refreshLayout = v.findViewById(R.id.refresh_noti);
        viewPager = v.findViewById(R.id.noti_viewpager);
        tabLayout = v.findViewById(R.id.noti_tab);
    }
}