package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.Product;
import com.example.ecngv2.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class RCV_Shop_Shop_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    public RCV_Shop_Shop_Adapter(Context context) {
        this.context = context;
    }

    private final int SLIDER = 0;
    private final int NEW_PRODUCT = 1;
    private final int HINT = 2;
    private final int PRODUCT = 3;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        switch (viewType){
            case SLIDER:
                v = LayoutInflater.from(context).inflate(R.layout.shop_slider, parent, false);
                return new SliderHolder(v);
            case NEW_PRODUCT:
                v = LayoutInflater.from(context).inflate(R.layout.shop_new_product, parent, false);
                return new NewProductHolder(v);
            case HINT:
                v = LayoutInflater.from(context).inflate(R.layout.shop_shop_hint, parent, false);
                return new HintHolder(v);
            case PRODUCT:
                v = LayoutInflater.from(context).inflate(R.layout.shop_shop_product, parent, false);
                return new ProductHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SliderHolder){
            List<Integer> banners = new ArrayList<>();
            banners.add(R.drawable.slider_1);
            banners.add(R.drawable.slider_2);
            banners.add(R.drawable.slider_3);
            banners.add(R.drawable.slider_4);
            banners.add(R.drawable.slider_5);
            ((SliderHolder)holder).sliderView.setSliderAdapter(new SliderViewHomeAdapter(context, banners));
            ((SliderHolder)holder).sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
            ((SliderHolder)holder).sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
            ((SliderHolder)holder).sliderView.startAutoCycle();
        } else if (holder instanceof NewProductHolder){
            List<Product> list_products = new ArrayList<>();
            list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.laptop1, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.dienthoai3, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));
            list_products.add(new Product(R.drawable.dongho, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));
            list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
            list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
            RCV_HotProduct_Adapter rcv_hotProduct_adapter = new RCV_HotProduct_Adapter(context, list_products);
            ((NewProductHolder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            ((NewProductHolder) holder).recyclerView.setAdapter(rcv_hotProduct_adapter);
        } else if (holder instanceof HintHolder){
            ((HintHolder) holder).txt.setTextColor(context.getColor(R.color.primary_color));
        } else if (holder instanceof ProductHolder){
            List<Product> productList = new ArrayList<>();
            loadData(productList);
            ((ProductHolder) holder).recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            RCV_Sugg_All_Adapter rcv_sugg_all_adapter = new RCV_Sugg_All_Adapter(context, productList);
            ((ProductHolder) holder).recyclerView.setAdapter(rcv_sugg_all_adapter);
            String[] list = new String[]{"--Chọn lọc--", "Giá tăng dần", "Giá giảm dần", "Yêu thích"};
            ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, list);
            ((ProductHolder) holder).spinner.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return SLIDER;
            case 1:
                return NEW_PRODUCT;
            case 2:
                return HINT;
            case 3:
                return PRODUCT;
        }
        return -1;
    }

    public class SliderHolder extends RecyclerView.ViewHolder {
        SliderView sliderView;
        public SliderHolder(@NonNull View itemView) {
            super(itemView);
            sliderView = itemView.findViewById(R.id.shop_slider);
        }
    }
    public class NewProductHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        public NewProductHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv_shop_new_product);
        }
    }
    public class HintHolder extends RecyclerView.ViewHolder {
        TextView txt;
        public HintHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.shop_shop_hint_txt);
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
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.cate_trangsuc, 99, "Laptop DELL inpression ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.cate_thoitrang, 999, "Laptop DELL inprsion ZT125 ECNG...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.cate_thucpham, 999, "Laptop DELL inprsion ZT125 ECNG...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.dienthoai3, 999, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.cate_thucung, 99, "Laptop DELL inpression ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 9, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 999, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai2, 99, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.cate_dongho, 999, "Laptop DELL inpresion ZT125 ECNG...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.cate_trangsuc, 99, "Laptop DELL inpression ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.cate_thoitrang, 999, "Laptop DELL inprsion ZT125 ECNG...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.cate_thucpham, 999, "Laptop DELL inprsion ZT125 ECNG...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.dienthoai3, 999, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.cate_thucung, 99, "Laptop DELL inpression ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 9, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 999, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai2, 99, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.cate_dongho, 999, "Laptop DELL inpresion ZT125 ECNG...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai1, 999, "Laptop DELL inpresion ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.cate_trangsuc, 99, "Laptop DELL inpression ZT125 ECNG...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.cate_thoitrang, 999, "Laptop DELL inprsion ZT125 ECNG...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.cate_thucpham, 999, "Laptop DELL inprsion ZT125 ECNG...", "999.000.000d", (float) 5));
    }
}
