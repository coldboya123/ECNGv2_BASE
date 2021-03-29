package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.Product;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class RCV_Home_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Product> list_products, hint_products;
    public RCV_Home_Adapter(Context context) {
        this.context = context;
    }

    final int XML = 0;
    final int HLPRODUCT = 1;
    final int CATE_PRODUCT = 2;
    final int HINT = 3;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        switch (viewType){
            case XML:
                v = LayoutInflater.from(context).inflate(R.layout.home_xemmualien, parent, false);
                return new XML_Holder(v);
            case HLPRODUCT:
                v = LayoutInflater.from(context).inflate(R.layout.rcv_hot_product, parent, false);
                return new HotProduct_Holder(v);
            case CATE_PRODUCT:
                v = LayoutInflater.from(context).inflate(R.layout.rcv_home_cate_product, parent, false);
                return new CateProduct_Holder(v);
            case HINT:
                v = LayoutInflater.from(context).inflate(R.layout.home_product_hint, parent, false);
                return new HintProduct_Holder(v);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (position){
            case 0:
                return XML;
            case 1:
                return HLPRODUCT;
            case 2:
                return CATE_PRODUCT;
            case 3:
                return HINT;
        }
        return -1;

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LoadData();
        if (holder instanceof XML_Holder){

        }else if (holder instanceof HotProduct_Holder){
            RCV_HotProduct_Adapter rcv_hotProduct_adapter = new RCV_HotProduct_Adapter(context, list_products);
            ((HotProduct_Holder) holder).recyclerView_HotProduct.setLayoutManager(new GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, false));
            ((HotProduct_Holder) holder).recyclerView_HotProduct.setAdapter(rcv_hotProduct_adapter);
        }else if (holder instanceof CateProduct_Holder){
            ((CateProduct_Holder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            ((CateProduct_Holder) holder).recyclerView.setAdapter(new RCV_HomeCateProduct_Adapter(context, list_products));
        } else if (holder instanceof HintProduct_Holder){
            ((HintProduct_Holder) holder).rcv.setLayoutManager(new GridLayoutManager(context, 2, RecyclerView.VERTICAL, false));
            ((HintProduct_Holder) holder).rcv.setAdapter(new RCV_HomeHintProduct_Adapter(context, hint_products));
        }
    }

    private void LoadData(){
        list_products = new ArrayList<>();
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre Laptop DELL inpre Laptop DELL inpre...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre Laptop DELL inpre Laptop DELL inpre...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre Laptop DELL inpre Laptop DELL inpre...", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.laptop1, 99, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai3, 999, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", 999000000, (float) 5));
        list_products.add(new Product(R.drawable.dongho, 999, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", 20000000, (float) 5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", 20000000, (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpre aptop DELL inpre Laptop DELL inpre......", 20000000, (float) 4.5));

        hint_products = new ArrayList<>();
        hint_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpresion ZT125 ECNG ZT125 ECNG ZT125 ECNG", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpresion ZT125 ECNG.ZT125 ECNG ZT125 ECNG", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.cate_trangsuc, 99, "Laptop DELL inpression ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.cate_thoitrang, 999, "Laptop DELL inprsion ZT125 ECNG...", 20000000, (float) 5));
        hint_products.add(new Product(R.drawable.cate_thucpham, 999, "Laptop DELL inprsion ZT125 ECNG...", 20000000, (float) 5));
        hint_products.add(new Product(R.drawable.dienthoai3, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.cate_thucung, 99, "Laptop DELL inpression ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dongho, 9, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.matkinh, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai2, 99, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.cate_dongho, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 5));
        hint_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.cate_trangsuc, 99, "Laptop DELL inpression ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.cate_thoitrang, 999, "Laptop DELL inprsion ZT125 ECNG...", 20000000, (float) 5));
        hint_products.add(new Product(R.drawable.cate_thucpham, 999, "Laptop DELL inprsion ZT125 ECNG...", 20000000, (float) 5));
        hint_products.add(new Product(R.drawable.dienthoai3, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.cate_thucung, 99, "Laptop DELL inpression ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dongho, 9, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.matkinh, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai2, 99, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.cate_dongho, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 5));
        hint_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.cate_trangsuc, 99, "Laptop DELL inpression ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.cate_thoitrang, 999, "Laptop DELL inprsion ZT125 ECNG...", 20000000, (float) 5));
        hint_products.add(new Product(R.drawable.cate_thucpham, 999, "Laptop DELL inprsion ZT125 ECNG...", 20000000, (float) 5));
        hint_products.add(new Product(R.drawable.dienthoai3, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.cate_thucung, 99, "Laptop DELL inpression ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dongho, 9, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.matkinh, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai2, 99, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.cate_dongho, 999, "Laptop DELL inpresion ZT125 ECNG...", 20000000, (float) 5));
    }

    public class XML_Holder extends RecyclerView.ViewHolder {
        public XML_Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
    public class HotProduct_Holder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView_HotProduct;
        public HotProduct_Holder(@NonNull View itemView) {
            super(itemView);
            recyclerView_HotProduct = itemView.findViewById(R.id.rcv_hot_product);
        }
    }

    public class CateProduct_Holder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        public CateProduct_Holder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv_product);
        }
    }

    public class HintProduct_Holder extends RecyclerView.ViewHolder{
        RecyclerView rcv;
        public HintProduct_Holder(@NonNull View itemView) {
            super(itemView);
            rcv = itemView.findViewById(R.id.rcv);
        }
    }

}
