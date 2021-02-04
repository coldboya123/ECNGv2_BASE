package com.example.ecngv2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.ecngv2.Adapter.RCV_Category_Adapter;
import com.example.ecngv2.Adapter.RCV_Home_Adapter;
import com.example.ecngv2.Adapter.SliderViewPagerAdapter;
import com.example.ecngv2.Fragment.AllSuggestionFragment;
import com.example.ecngv2.Fragment.BikeSuggestionFragment;
import com.example.ecngv2.Fragment.TechSuggestionFragment;
import com.example.ecngv2.Model.Category;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    ViewPager viewPager;
    List<Integer> list;
    List<Category> categoryList;
    RecyclerView recycler_category, recycler_home;
    TabLayout tabLayout;
    Fragment fragmentAll, fragmentBike, fragmentTech, acivefragment;
    androidx.appcompat.widget.Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        Context context = getContext();
        init(v);
        FragmentManager fm = getChildFragmentManager();

        //set Onclick for toolbar
        toolbar.setOnMenuItemClickListener(new androidx.appcompat.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.shopping_cart:
                        context.startActivity(new Intent(getContext(), CartActivity.class));
                        return true;
//                    case R.id.notification:
//                        context.startActivity(new Intent(getContext(), CartActivity.class));
                }
                return false;
            }
        });

        //Set Adapter for ViewPager
        int[] imagesRes = new int[]{R.drawable.slider_1, R.drawable.slider_2, R.drawable.slider_3, R.drawable.slider_4, R.drawable.slider_5};
        SliderViewPagerAdapter bannerAdapter = new SliderViewPagerAdapter(getContext(), imagesRes);
        viewPager.setAdapter(bannerAdapter);

        //Set Adapter for RecyclerView Category
        categoryList.add(new Category("Đồng hồ", R.drawable.dongho));
        categoryList.add(new Category("Mắt kính", R.drawable.matkinh));
        categoryList.add(new Category("Công nghệ", R.drawable.laptop));
        categoryList.add(new Category("Gái đẹp", R.drawable.category_1));
        categoryList.add(new Category("Gái xinh", R.drawable.category_2));
        RCV_Category_Adapter rcv_category_adapter = new RCV_Category_Adapter(getContext(), categoryList);
        recycler_category.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recycler_category.setNestedScrollingEnabled(false);
        recycler_category.setAdapter(rcv_category_adapter);

        //Set Adapter for RecyclerView Home
        RCV_Home_Adapter rcv_home_adapter = new RCV_Home_Adapter(getContext());
        recycler_home.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recycler_home.setAdapter(rcv_home_adapter);

        //Suggestion
        View view;
        int numtab = 9;
        for (int i=0; i<numtab; i++){
            view = LayoutInflater.from(context).inflate(R.layout.custom_icon_tablayout, null);
            int icon = context.getResources().getIdentifier("ic_suggestion_"+ i, "drawable",context.getPackageName());
            int title = context.getResources().getIdentifier("title_suggestion_"+ i, "string",context.getPackageName());
            ImageView img = view.findViewById(R.id.icon_suggestiontab);
            img.setImageResource(icon);
            TextView suggestion_title = view.findViewById(R.id.title_suggestiontab);
            suggestion_title.setText(title);
            TabLayout.Tab tabItem = tabLayout.newTab();
            tabItem.setCustomView(view);
            tabLayout.addTab(tabItem);
        }
        fm.beginTransaction().add(R.id.suggestion_content, fragmentTech, "tech").hide(fragmentTech).commit();
        fm.beginTransaction().add(R.id.suggestion_content, fragmentBike, "bike").hide(fragmentBike).commit();
        fm.beginTransaction().add(R.id.suggestion_content, fragmentAll, "all").commit();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        fm.beginTransaction().hide(acivefragment).show(fragmentAll).commit();
                        acivefragment = fragmentAll;
                        return;
                    case 1:
                        fm.beginTransaction().hide(acivefragment).show(fragmentBike).commit();
                        acivefragment = fragmentBike;
                        return;
                    case 2:
                        fm.beginTransaction().hide(acivefragment).show(fragmentTech).commit();
                        acivefragment = fragmentTech;
                        return;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return v;
    }

    private void init(View v){
        recycler_home = v.findViewById(R.id.recycler_home);
        viewPager = v.findViewById(R.id.slide_banner);
        tabLayout = v.findViewById(R.id.tab_suggestion);
        toolbar = v.findViewById(R.id.toolbar);
        list = new ArrayList<>();
        recycler_category = v.findViewById(R.id.recycler_category);
        categoryList = new ArrayList<>();
        fragmentAll = new AllSuggestionFragment();
        fragmentBike = new BikeSuggestionFragment();
        fragmentTech = new TechSuggestionFragment();
        acivefragment = fragmentAll;
    }
}