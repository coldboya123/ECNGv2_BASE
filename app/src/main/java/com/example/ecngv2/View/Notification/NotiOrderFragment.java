package com.example.ecngv2.View.Notification;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecngv2.Adapter.RCV_Noti_Order_Adapter;
import com.example.ecngv2.Model.Object.NotiOrder;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class NotiOrderFragment extends Fragment {

    RecyclerView recyclerView;
    List<NotiOrder> list;
    public NotiOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_noti_order, container, false);

        init(v);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(new RCV_Noti_Order_Adapter(getContext(), list));

        return v;
    }

    private void init(View v){
        recyclerView = v.findViewById(R.id.rcv_noti_order);

        list = new ArrayList<>();
        list.add(new NotiOrder(R.drawable.laptop3, "NDTV Gadgets 360 Mi Gaming Laptop Professional 2019", "Đã giao"));
        list.add(new NotiOrder(R.drawable.dienthoai2, "NDTV Gadgets 360 Mi Gaming Laptop Professional 2019", "Đang giao"));
        list.add(new NotiOrder(R.drawable.laptop7, "NDTV Gadgets 360 Mi Gaming Laptop Professional 2019", "Đã hủy"));
    }
}