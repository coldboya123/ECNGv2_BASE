package com.example.ecngv2.View.Category;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ecngv2.Adapter.Cate_Computer_Adapter;
import com.example.ecngv2.Model.Object.Cate_tabItem;
import com.example.ecngv2.Model.Object.Category;
import com.example.ecngv2.Model.Object.ItemCateTab;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class CategoryFragment extends Fragment {
    Fragment fragmentAll, fragmentBike, fragmentTech, acivefragment;


    public CategoryFragment() {
        // Required empty public constructor
    }
    RecyclerView rcv_catetab;
    TextView title;
    VerticalTabLayout tabLayout;
    List<ItemCateTab> listItem;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_category, container, false);

        title = v.findViewById(R.id.title_cate);
        rcv_catetab = v.findViewById(R.id.rcv_cate_content);

        tabLayout = v.findViewById(R.id.cate_tabs);
        tabLayout.setIndicatorColor(getActivity().getColor(R.color.white));
        tabLayout.setTabAdapter(new MyTabAdapter());
        tabLayout.setTabSelected(0);
        rcv_catetab.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        title.setText("Máy tính & Laptop");
        listItem = new ArrayList<>();
        loadData0(listItem);
        Cate_Computer_Adapter computer_adapter = new Cate_Computer_Adapter(getContext(), listItem);
        rcv_catetab.setAdapter(computer_adapter);
        tabLayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                Cate_Computer_Adapter computer_adapter;
                if (position == 0){
                    title.setText("Máy tính & Laptop");
                    listItem = new ArrayList<>();
                    loadData0(listItem);
                    computer_adapter = new Cate_Computer_Adapter(getContext(), listItem);
                    computer_adapter.notifyDataSetChanged();
                    rcv_catetab.setAdapter(computer_adapter);
                }else if (position == 1){
                    title.setText("Thời trang nữ");
                    listItem = new ArrayList<>();
                    loadData1(listItem);
                    computer_adapter = new Cate_Computer_Adapter(getContext(), listItem);
                    computer_adapter.notifyDataSetChanged();
                    rcv_catetab.setAdapter(computer_adapter);
                }else if (position == 2){
                    title.setText("Thời trang nam");
                }else if (position == 3){
                    title.setText("Rượu");
                }else if (position == 4){
                    title.setText("Căn hộ");
                }
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
        return v;
    }

    private void loadData0(List<ItemCateTab> listItem){
        List<Category> listcate;
        listcate = new ArrayList<>();
        listcate.add(new Category("Macbook", R.drawable.laptop));
        listcate.add(new Category("Dell", R.drawable.laptop));
        listcate.add(new Category("Samsung", R.drawable.laptop));
        listcate.add(new Category("Asus", R.drawable.laptop));
        listcate.add(new Category("Acer", R.drawable.laptop));
        listcate.add(new Category("LG", R.drawable.laptop));
        listcate.add(new Category("Lenovo", R.drawable.laptop));
        listItem.add(new ItemCateTab("Danh mục phổ biến", listcate));
        listcate = new ArrayList<>();
        listcate.add(new Category("Macbook", R.drawable.laptop));
        listcate.add(new Category("Dell", R.drawable.laptop));
        listcate.add(new Category("Samsung", R.drawable.laptop));
        listcate.add(new Category("Asus", R.drawable.laptop));
        listcate.add(new Category("Acer", R.drawable.laptop));
        listcate.add(new Category("LG", R.drawable.laptop));
        listcate.add(new Category("Lenovo", R.drawable.laptop));
        listItem.add(new ItemCateTab("Laptop", listcate));
        listcate = new ArrayList<>();
        listcate.add(new Category("Macbook", R.drawable.laptop));
        listcate.add(new Category("Dell", R.drawable.laptop));
        listcate.add(new Category("Samsung", R.drawable.laptop));
        listcate.add(new Category("Asus", R.drawable.laptop));
        listcate.add(new Category("Acer", R.drawable.laptop));
        listcate.add(new Category("LG", R.drawable.laptop));
        listItem.add(new ItemCateTab("Máy tính", listcate));
    }
    private void loadData1(List<ItemCateTab> listItem){
        List<Category> listcate;
        listcate = new ArrayList<>();
        listcate.add(new Category("Macbook", R.drawable.laptop));
        listcate.add(new Category("Dell", R.drawable.laptop));
        listcate.add(new Category("Samsung", R.drawable.laptop));
        listcate.add(new Category("Asus", R.drawable.laptop));
        listcate.add(new Category("Acer", R.drawable.laptop));
        listcate.add(new Category("LG", R.drawable.laptop));
        listcate.add(new Category("Lenovo", R.drawable.laptop));
        listItem.add(new ItemCateTab("Danh mục phổ biến", listcate));
        listcate = new ArrayList<>();
        listcate.add(new Category("Samsung", R.drawable.laptop));
        listcate.add(new Category("Asus", R.drawable.laptop));
        listcate.add(new Category("Acer", R.drawable.laptop));
        listcate.add(new Category("LG", R.drawable.laptop));
        listcate.add(new Category("Lenovo", R.drawable.laptop));
        listItem.add(new ItemCateTab("Laptop", listcate));
        listcate = new ArrayList<>();
        listcate.add(new Category("Macbook", R.drawable.laptop));
        listcate.add(new Category("Dell", R.drawable.laptop));
        listcate.add(new Category("Samsung", R.drawable.laptop));
        listcate.add(new Category("Asus", R.drawable.laptop));
        listcate.add(new Category("Acer", R.drawable.laptop));
        listcate.add(new Category("LG", R.drawable.laptop));
        listcate.add(new Category("Macbook", R.drawable.laptop));
        listcate.add(new Category("Dell", R.drawable.laptop));
        listcate.add(new Category("Samsung", R.drawable.laptop));
        listcate.add(new Category("Asus", R.drawable.laptop));
        listcate.add(new Category("Acer", R.drawable.laptop));
        listcate.add(new Category("LG", R.drawable.laptop));
        listItem.add(new ItemCateTab("Máy tính", listcate));
    }


    private class MyTabAdapter implements TabAdapter {

        List<Cate_tabItem> list;

        public MyTabAdapter() {
            list = new ArrayList<>();
            list.add(new Cate_tabItem("Máy tính & Laptop", R.drawable.devices, R.drawable.devices_actived));
            list.add(new Cate_tabItem("Thời trang nữ",  R.drawable.dress_1, R.drawable.dress_2));
            list.add(new Cate_tabItem("Thời trang nam",  R.drawable.suit_1, R.drawable.suit_2));
            list.add(new Cate_tabItem("Rượu",  R.drawable.wine_1, R.drawable.wine_2));
            list.add(new Cate_tabItem("Căn hộ",  R.drawable.skyline_1, R.drawable.skyline_2));
            list.add(new Cate_tabItem("Máy tính & Laptop", R.drawable.devices, R.drawable.devices_actived));
            list.add(new Cate_tabItem("Thời trang nữ",  R.drawable.dress_1, R.drawable.dress_2));
            list.add(new Cate_tabItem("Thời trang nam",  R.drawable.suit_1, R.drawable.suit_2));
            list.add(new Cate_tabItem("Rượu",  R.drawable.wine_1, R.drawable.wine_2));
            list.add(new Cate_tabItem("Căn hộ",  R.drawable.skyline_1, R.drawable.skyline_2));
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public ITabView.TabBadge getBadge(int position) {
            return null;
        }


        @Override
        public TabView.TabIcon getIcon(int position) {
            Cate_tabItem cate = list.get(position);
            return new TabView.TabIcon.Builder()
                    .setIcon(cate.getImg_selected(), cate.getImg_normal())
                    .setIconGravity(Gravity.TOP)
                    .setIconMargin(0)
                    .setIconSize(100, 100)
                    .build();
        }

        @Override
        public TabView.TabTitle getTitle(int position) {
            Cate_tabItem cate = list.get(position);
            return new TabView.TabTitle.Builder()
                    .setContent(cate.getTitle())
                    .setTextColor(getActivity().getColor(R.color.primary_color),getActivity().getColor(R.color.black))
                    .build();
        }

        @Override
        public int getBackground(int position) {
            return -1;
        }

    }

}