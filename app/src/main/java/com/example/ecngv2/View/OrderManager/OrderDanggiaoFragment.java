package com.example.ecngv2.View.OrderManager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecngv2.Adapter.RCV_OrderManager_Adapter;
import com.example.ecngv2.Model.Object.OrderItem;
import com.example.ecngv2.Model.Object.OrderManager;
import com.example.ecngv2.Model.Object.ProductCartItem;
import com.example.ecngv2.Model.Object.ProductPayment;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class OrderDanggiaoFragment extends Fragment {

    RecyclerView rcv;
    List<OrderManager> orderManagers;
    List<OrderItem> orderItems;
    List<ProductCartItem> products;

    public OrderDanggiaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ordermanager_content, container, false);
        init(v);
        rcv.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rcv.setAdapter(new RCV_OrderManager_Adapter(getContext(), orderManagers, false));
        return v;
    }

    private void init(View v){
        rcv = v.findViewById(R.id.rcv_ordermanager);

        orderManagers = new ArrayList<>();
        orderItems = new ArrayList<>();

        products = new ArrayList<>();
        products.add(new ProductCartItem(R.drawable.laptop2, 2, "Laptop Dell Latitude 1280", 30000000, "Đen", true));
        products.add(new ProductCartItem(R.drawable.dienthoai1, 2, "Laptop Dell Latitude 1280", 30000000, "Đen", true));
        orderItems.add(new OrderItem("apple_long_butterfly", "[Kho trung chuyển Tân Bình]", products));
        products = new ArrayList<>();
        products.add(new ProductCartItem(R.drawable.laptop6, 2, "Laptop Dell Latitude 1280", 30000000, "Đen", true));
        orderItems.add(new OrderItem("toi_tai_tu", "[Kho trung chuyển Tân Phú]", products));
        orderManagers.add(new OrderManager("123456", "10:10 15/03/2020", 120000000, orderItems));

        orderItems = new ArrayList<>();
        products = new ArrayList<>();
        products.add(new ProductCartItem(R.drawable.laptop4, 2, "Laptop Dell Latitude 1280", 30000000, "Đen", true));
        orderItems.add(new OrderItem("huy_provip", "[Kho trung chuyển Tân Phú]", products));

        orderManagers.add(new OrderManager("112233", "7:10 12/03/2020", 60000000, orderItems));
    }
}