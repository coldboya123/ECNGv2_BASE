package com.example.ecngv2.View.Category;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecngv2.Adapter.RCV_CategoryTab_Adapter;
import com.example.ecngv2.Adapter.RCV_Category_Adapter;
import com.example.ecngv2.Model.Object.Category;
import com.example.ecngv2.Model.Object.CategoryList;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    List<Category> categoryList, categoryItemList;
    List<CategoryList> lists;
    RecyclerView rcv_cate, rcv_item;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_category, container, false);
        init(v);
        loadData();
        rcv_cate.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        rcv_cate.setAdapter(new RCV_CategoryTab_Adapter(getContext(), categoryList));

        rcv_item.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rcv_item.setAdapter(new RCV_Category_Adapter(getContext(), lists));
        return v;
    }

    private void init(View v){
        rcv_cate = v.findViewById(R.id.rcv_category);
        rcv_item = v.findViewById(R.id.rcv_cate_item);
    }

    private void loadData(){
        categoryList = new ArrayList<>();
        categoryList.add(new Category("Bất Động Sản", R.drawable.cate_batdongsan, true));
        categoryList.add(new Category("Công Nghệ", R.drawable.cate_congnghe, false));
        categoryList.add(new Category("Đồng Hồ", R.drawable.cate_dongho, false));
        categoryList.add(new Category("Gia Dụng", R.drawable.cate_giadung, false));
        categoryList.add(new Category("Làm Đẹp", R.drawable.cate_lamdep, false));
        categoryList.add(new Category("Mỹ Phẩm", R.drawable.cate_mypham, false));
        categoryList.add(new Category("Thời Trang", R.drawable.cate_thoitrang, false));
        categoryList.add(new Category("Thực Phẩm", R.drawable.cate_thucpham, false));
        categoryList.add(new Category("Thú Cưng", R.drawable.cate_thucung, false));
        categoryList.add(new Category("Trang Sức", R.drawable.cate_trangsuc, true));

        lists = new ArrayList<>();
        categoryItemList = new ArrayList<>();
        categoryItemList.add(new Category("Iphone", R.drawable.logo_mac));
        categoryItemList.add(new Category("Samsung", R.drawable.logo_samsung));
        categoryItemList.add(new Category("LG", R.drawable.logo_lg));
        categoryItemList.add(new Category("Vertu", R.drawable.logo_vertu));
        categoryItemList.add(new Category("Vsmart", R.drawable.logo_vsmart));
        categoryItemList.add(new Category("Xiaomi", R.drawable.logo_xiaomi));
        lists.add(new CategoryList("Điện Thoại", categoryItemList, true));

        categoryItemList = new ArrayList<>();
        categoryItemList.add(new Category("Iphone", R.drawable.logo_mac));
        categoryItemList.add(new Category("Samsung", R.drawable.logo_samsung));
        categoryItemList.add(new Category("LG", R.drawable.logo_lg));
        categoryItemList.add(new Category("Vertu", R.drawable.logo_vertu));
        categoryItemList.add(new Category("Vsmart", R.drawable.logo_vsmart));
        categoryItemList.add(new Category("Xiaomi", R.drawable.logo_xiaomi));
        lists.add(new CategoryList("Máy Tính Bản", categoryItemList, true));

        categoryItemList = new ArrayList<>();
        categoryItemList.add(new Category("Iphone", R.drawable.logo_mac));
        categoryItemList.add(new Category("Samsung", R.drawable.logo_samsung));
        categoryItemList.add(new Category("LG", R.drawable.logo_lg));
        categoryItemList.add(new Category("Vertu", R.drawable.logo_vertu));
        categoryItemList.add(new Category("Vsmart", R.drawable.logo_vsmart));
        categoryItemList.add(new Category("Xiaomi", R.drawable.logo_xiaomi));
        lists.add(new CategoryList("Laptop", categoryItemList, true));

        categoryItemList = new ArrayList<>();
        categoryItemList.add(new Category("Iphone", R.drawable.logo_mac));
        categoryItemList.add(new Category("Samsung", R.drawable.logo_samsung));
        categoryItemList.add(new Category("LG", R.drawable.logo_lg));
        categoryItemList.add(new Category("Vertu", R.drawable.logo_vertu));
        categoryItemList.add(new Category("Vsmart", R.drawable.logo_vsmart));
        categoryItemList.add(new Category("Xiaomi", R.drawable.logo_xiaomi));
        lists.add(new CategoryList("Phụ Kiện", categoryItemList, true));
    }
}