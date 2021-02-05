package com.example.ecngv2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Adapter.RCV_Shop_Product_Adapter;

public class Shop_Product_Fragment extends Fragment {


    public Shop_Product_Fragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_shop__product_, container, false);
        recyclerView = v.findViewById(R.id.rcv_shop_product);
        RCV_Shop_Product_Adapter adapter = new RCV_Shop_Product_Adapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        return v;
    }
}