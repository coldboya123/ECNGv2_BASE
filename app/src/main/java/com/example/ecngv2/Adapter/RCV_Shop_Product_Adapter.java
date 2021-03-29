package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.Product;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class RCV_Shop_Product_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;

    public RCV_Shop_Product_Adapter(Context context) {
        this.context = context;
    }

    private final int NEW_PRODUCT = 0;
    private final int PRODUCT = 1;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        switch (viewType){
            case NEW_PRODUCT:
                v = LayoutInflater.from(context).inflate(R.layout.shop_new_product, parent, false);
                return new RCV_Shop_Product_Adapter.NewProductHolder(v);
            case PRODUCT:
                v = LayoutInflater.from(context).inflate(R.layout.shop_shop_product, parent, false);
                return new RCV_Shop_Product_Adapter.ProductHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RCV_Shop_Product_Adapter.NewProductHolder){
            List<Product> list_products = new ArrayList<>();
            list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", 20000000, (float) 4.5));
            list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", 20000000, (float) 4.5));
            list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre...", 20000000, (float) 4.5));
            list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpre...", 20000000, (float) 4.5));
            list_products.add(new Product(R.drawable.laptop1, 99, "Laptop DELL inpre...", 20000000, (float) 4.5));
            list_products.add(new Product(R.drawable.dienthoai3, 999, "Laptop DELL inpre...", 999000000, (float) 5));
            list_products.add(new Product(R.drawable.dongho, 999, "Laptop DELL inpre...", 999000000, (float) 5));
            list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", 20000000, (float) 4.5));
            list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", 20000000, (float) 4.5));
            list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre...", 20000000, (float) 4.5));
            list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpre...", 20000000, (float) 4.5));
            RCV_HotProduct_Adapter rcv_hotProduct_adapter = new RCV_HotProduct_Adapter(context, list_products);
            ((RCV_Shop_Product_Adapter.NewProductHolder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            ((RCV_Shop_Product_Adapter.NewProductHolder) holder).recyclerView.setAdapter(rcv_hotProduct_adapter);
        } else if (holder instanceof RCV_Shop_Product_Adapter.ProductHolder){
            List<Product> productList = new ArrayList<>();
            loadData(productList);
            ((RCV_Shop_Product_Adapter.ProductHolder) holder).recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            RCV_HomeHintProduct_Adapter rcv_homeHintProduct_adapter = new RCV_HomeHintProduct_Adapter(context, productList);
            ((RCV_Shop_Product_Adapter.ProductHolder) holder).recyclerView.setAdapter(rcv_homeHintProduct_adapter);
            String[] list = new String[]{"--Chọn lọc--", "Giá tăng dần", "Giá giảm dần", "Yêu thích"};
            ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, list);
            ((RCV_Shop_Product_Adapter.ProductHolder) holder).spinner.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return NEW_PRODUCT;
            case 1:
                return PRODUCT;
        }
        return -1;
    }

    public class NewProductHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        public NewProductHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv_shop_new_product);
        }
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        Spinner spinner;
        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv_shop_shop_product);
            spinner = itemView.findViewById(R.id.shop_shop_spinner);
        }
    }

    private void loadData(List<Product> list_products){
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.cate_trangsuc, 99, "Laptop DELL inpression ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.cate_thoitrang, 999, "Laptop DELL inprsion ZT125 ECNG...", 999000000, (float) 5));
        list_products.add(new Product(R.drawable.cate_thucpham, 999, "Laptop DELL inprsion ZT125 ECNG...", 999000000, (float) 5));
        list_products.add(new Product(R.drawable.dienthoai3, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.cate_thucung, 99, "Laptop DELL inpression ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 9, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai2, 99, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.cate_dongho, 999, "Laptop DELL inpresion ZT125 ECNG...", 999000000, (float) 5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.cate_trangsuc, 99, "Laptop DELL inpression ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.cate_thoitrang, 999, "Laptop DELL inprsion ZT125 ECNG...", 999000000, (float) 5));
        list_products.add(new Product(R.drawable.cate_thucpham, 999, "Laptop DELL inprsion ZT125 ECNG...", 999000000, (float) 5));
        list_products.add(new Product(R.drawable.dienthoai3, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.cate_thucung, 99, "Laptop DELL inpression ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 9, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai2, 99, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.cate_dongho, 999, "Laptop DELL inpresion ZT125 ECNG...", 999000000, (float) 5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.cate_trangsuc, 99, "Laptop DELL inpression ZT125 ECNG...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.cate_thoitrang, 999, "Laptop DELL inprsion ZT125 ECNG...", 999000000, (float) 5));
        list_products.add(new Product(R.drawable.cate_thucpham, 999, "Laptop DELL inprsion ZT125 ECNG...", 999000000, (float) 5));
    }
}
