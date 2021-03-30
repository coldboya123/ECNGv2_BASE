package com.example.ecngv2.View.Favorite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecngv2.Adapter.RCV_FavShop_Adapter;
import com.example.ecngv2.Model.Object.Shop;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class FavShopFragment extends Fragment {

    public FavShopFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    List<Shop> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_fav_shop, container, false);
        init(v);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(new RCV_FavShop_Adapter(getContext(), list));
        return v;
    }

    private void init(View v) {
        recyclerView = v.findViewById(R.id.rcv);
        list = new ArrayList<>();
        list.add(new Shop("toi_tai_tu", R.drawable.avatar_user));
        list.add(new Shop("toi_tai_tu", R.drawable.avatar_user));
        list.add(new Shop("toi_tai_tu", R.drawable.avatar_user));
        list.add(new Shop("toi_tai_tu", R.drawable.avatar_user));
    }
}