package com.example.ecngv2.View.Home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.ecngv2.Adapter.RCV_HomeNewProduct_Adapter;
import com.example.ecngv2.Adapter.RCV_Home_Adapter;
import com.example.ecngv2.Adapter.RCV_Home_Category_Adapter;
import com.example.ecngv2.Adapter.SliderViewHomeAdapter;
import com.example.ecngv2.Model.Object.Category;
import com.example.ecngv2.Model.Object.Product;
import com.example.ecngv2.R;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    SwipeRefreshLayout refreshLayout;
    SliderView sliderView;
    List<Integer> list;
    List<Integer> banners;
    List<Category> categoryList;
    SearchView searchView;
    ImageView banner;
    List<Product> productList;
    RecyclerView recycler_category, recycler_home, rcv_newproduct;
    TabLayout tabLayout;
//    Fragment fragmentAll, fragmentBike, fragmentTech, acivefragment;
    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        Context context = getContext();
        init(v);

        refreshLayout.setOnRefreshListener(() -> refreshLayout.setRefreshing(false));

        FragmentManager fm = getChildFragmentManager();

        //set Onclick for toolbar
        toolbar.setOnMenuItemClickListener(new androidx.appcompat.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
//                    case R.id.shopping_cart:
//                        context.startActivity(new Intent(getContext(), CartActivity.class));
//                        return true;
//                    case R.id.notification:
//                        context.startActivity(new Intent(getContext(), CartActivity.class));
                }
                return false;
            }
        });

        LinearLayout linearLayout1 = (LinearLayout) searchView.getChildAt(0);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout1.getChildAt(2);
        LinearLayout linearLayout3 = (LinearLayout) linearLayout2.getChildAt(1);
        AutoCompleteTextView autoComplete = (AutoCompleteTextView) linearLayout3.getChildAt(0);
        autoComplete.setTextSize(15);
        searchView.setOnClickListener(v1 -> {
            searchView.setIconified(false);
        });

        banner.setClipToOutline(true);

        rcv_newproduct.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        rcv_newproduct.setAdapter(new RCV_HomeNewProduct_Adapter(getContext(), productList));

        sliderView.setSliderAdapter(new SliderViewHomeAdapter(getContext(), banners));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();

        //Set Adapter for RecyclerView Category
        categoryList.add(new Category("Bất Động Sản", R.drawable.cate_batdongsan));
        categoryList.add(new Category("Công Nghệ", R.drawable.cate_congnghe));
        categoryList.add(new Category("Đồng Hồ", R.drawable.cate_dongho));
        categoryList.add(new Category("Gia Dụng", R.drawable.cate_giadung));
        categoryList.add(new Category("Làm Đẹp", R.drawable.cate_lamdep));
        categoryList.add(new Category("Mỹ Phẩm", R.drawable.cate_mypham));
        categoryList.add(new Category("Thời Trang", R.drawable.cate_thoitrang));
        categoryList.add(new Category("Thực Phẩm", R.drawable.cate_thucpham));
        categoryList.add(new Category("Thú Cưng", R.drawable.cate_thucung));
        categoryList.add(new Category("Trang Sức", R.drawable.cate_trangsuc));

        RCV_Home_Category_Adapter rcv_Home_category_adapter = new RCV_Home_Category_Adapter(getContext(), categoryList);
        recycler_category.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recycler_category.setAdapter(rcv_Home_category_adapter);

        //Set Adapter for RecyclerView Home
        RCV_Home_Adapter rcv_home_adapter = new RCV_Home_Adapter(getContext());
        recycler_home.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recycler_home.setAdapter(rcv_home_adapter);


        return v;
    }

    private void init(View v) {
        refreshLayout = v.findViewById(R.id.refresh_home);

        searchView = v.findViewById(R.id.searchbar);

        recycler_home = v.findViewById(R.id.recycler_home);
        sliderView = v.findViewById(R.id.slide_banner);
        toolbar = v.findViewById(R.id.toolbar);
        list = new ArrayList<>();
        recycler_category = v.findViewById(R.id.recycler_category);
        categoryList = new ArrayList<>();

        banners = new ArrayList<>();
        banners.add(R.drawable.banner_home_5);
        banners.add(R.drawable.banner_home_6);
        banners.add(R.drawable.banner_home_3);
        banners.add(R.drawable.banner_home_4);
        banners.add(R.drawable.banner_home_5);
        banners.add(R.drawable.banner_home_6);

        rcv_newproduct = v.findViewById(R.id.rcv_newproduct);
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.dongho, 10000000));
        productList.add(new Product(R.drawable.matkinh, 10000000));
        productList.add(new Product(R.drawable.laptop1, 10000000));
        productList.add(new Product(R.drawable.laptop3, 10000000));
        productList.add(new Product(R.drawable.laptop7, 10000000));
        productList.add(new Product(R.drawable.laptop6, 10000000));

        banner = v.findViewById(R.id.banner);
    }
}