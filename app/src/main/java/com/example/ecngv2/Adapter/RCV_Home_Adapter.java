package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.Product;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class RCV_Home_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    public RCV_Home_Adapter(Context context) {
        this.context = context;
    }

    final int VENDOR = 0;
    final int HLPRODUCT = 1;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        switch (viewType){
            case VENDOR:
                v = LayoutInflater.from(context).inflate(R.layout.rcv_vendor, parent, false);
                return new Vendor_Holder(v);
            case HLPRODUCT:
                v = LayoutInflater.from(context).inflate(R.layout.rcv_hightlight_product, parent, false);
                return new HLProduct_Holder(v);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (position){
            case 0:
                return VENDOR;
            case 1:
                return HLPRODUCT;
        }
        return -1;

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Vendor_Holder){
            List<Integer> list_vendors = new ArrayList<>();
            list_vendors.add(R.drawable.ken);
            list_vendors.add(R.drawable.bud);
            list_vendors.add(R.drawable.ken);
            list_vendors.add(R.drawable.bud);
            list_vendors.add(R.drawable.ken);
            list_vendors.add(R.drawable.bud);
            list_vendors.add(R.drawable.ken);
            list_vendors.add(R.drawable.bud);
            RCV_vendor_adapter rcv_vendor_adapter = new RCV_vendor_adapter(context, list_vendors);
            ((Vendor_Holder) holder).recyclerViewvendor.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            ((Vendor_Holder) holder).recyclerViewvendor.setAdapter(rcv_vendor_adapter);
        } else if (holder instanceof HLProduct_Holder){
            List<Product> list_products = new ArrayList<>();
            list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre Laptop DELL inpre Laptop DELL inpre...", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre Laptop DELL inpre Laptop DELL inpre...", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre Laptop DELL inpre Laptop DELL inpre...", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.laptop1, 99, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.dienthoai3, 999, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", "999.000.000d", (float) 5));
            list_products.add(new Product(R.drawable.dongho, 999, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", "999.000.000d", (float) 5));
            list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", "20.000.000d", (float) 4.5));
            RCV_HLProduct_Adapter rcv_hlProduct_adapter = new RCV_HLProduct_Adapter(context, list_products);
            ((HLProduct_Holder) holder).recyclerView_HLProduct.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            ((HLProduct_Holder) holder).recyclerView_HLProduct.setAdapter(rcv_hlProduct_adapter);
        }
    }



    public class Vendor_Holder extends RecyclerView.ViewHolder {
        RecyclerView recyclerViewvendor;
        public Vendor_Holder(@NonNull View itemView) {
            super(itemView);
            recyclerViewvendor = itemView.findViewById(R.id.recycler_vendor);
        }
    }
    public class HLProduct_Holder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView_HLProduct;
        public HLProduct_Holder(@NonNull View itemView) {
            super(itemView);
            recyclerView_HLProduct = itemView.findViewById(R.id.recycler_hightlight_product);
        }
    }

}
