package com.example.ecngv2.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecngv2.Adapter.RCV_Sugg_All_Adapter;
import com.example.ecngv2.Model.Product;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class BikeSuggestionFragment extends Fragment {



    public BikeSuggestionFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_all_suggestion, container, false);
        recyclerView = v.findViewById(R.id.rcv_suggestion_all);
        List<Product> list_products = new ArrayList<>();
        loadData(list_products);
        RCV_Sugg_All_Adapter adapter = new RCV_Sugg_All_Adapter(getContext(), list_products);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);
        return v;
    }
    private void loadData(List<Product> list_products){
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.category_2, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.category_1, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.category_2, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.category_1, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.category_2, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.category_1, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.category_2, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.category_1, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));

    }
}