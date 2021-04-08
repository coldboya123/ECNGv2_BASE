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
        list_products.add(new Product(R.drawable.img_laptoplenovoideapads340, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, (float) 4.5));
        list_products.add(new Product(R.drawable.img_applewatchs5lte, 99, "Apple Watch S5 LTE 40mm viền thép dây thép bạc", 17592000, (float) 4.5));
        list_products.add(new Product(R.drawable.img_laptophppavilion, 9, "Laptop HP Pavilion x360 dw1016TU i3 1115G4/4GB/256GB/Touch/Pen/Office H&S2019/Win10 (2H3Q0PA)", 14490000, (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai1, 999, "Điện thoại iPhone 12 Pro 512GB", 36990000, (float) 4.5));
        list_products.add(new Product(R.drawable.img_airpodspro, 99, "Tai nghe Bluetooth AirPods Pro Wireless Charge Apple MWP22", 5490000, (float) 4.5));
        list_products.add(new Product(R.drawable.dienthoai3, 999, "Điện thoại Realme C15", 15000000, (float) 5));
        list_products.add(new Product(R.drawable.dongho, 999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, (float) 5));
        list_products.add(new Product(R.drawable.img_laptopacernitro, 999, "Laptop Acer Nitro AN515 44 R9JM R5 4600H/8GB/512GB/4GB GTX1650/144Hz/Win10 (NH.Q9MSV.003)", 22990000, (float) 4.5));
        list_products.add(new Product(R.drawable.img_laptoplenovoideapad, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, (float) 4.5));
        list_products.add(new Product(R.drawable.img_galaxyzfold2, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, (float) 4.5));
        list_products.add(new Product(R.drawable.img_ipadpro11, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, (float) 4.5));

        hint_products = new ArrayList<>();
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapads340, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_applewatchs5lte, 99, "Apple Watch S5 LTE 40mm viền thép dây thép bạc", 17592000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_laptophppavilion, 9, "Laptop HP Pavilion x360 dw1016TU i3 1115G4/4GB/256GB/Touch/Pen/Office H&S2019/Win10 (2H3Q0PA)", 14490000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai1, 999, "Điện thoại iPhone 12 Pro 512GB", 36990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_airpodspro, 99, "Tai nghe Bluetooth AirPods Pro Wireless Charge Apple MWP22", 5490000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai3, 999, "Điện thoại Realme C15", 15000000, (float) 5));
        hint_products.add(new Product(R.drawable.dongho, 999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, (float) 5));
        hint_products.add(new Product(R.drawable.img_laptopacernitro, 999, "Laptop Acer Nitro AN515 44 R9JM R5 4600H/8GB/512GB/4GB GTX1650/144Hz/Win10 (NH.Q9MSV.003)", 22990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapad, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_galaxyzfold2, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_ipadpro11, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapads340, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_applewatchs5lte, 99, "Apple Watch S5 LTE 40mm viền thép dây thép bạc", 17592000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_laptophppavilion, 9, "Laptop HP Pavilion x360 dw1016TU i3 1115G4/4GB/256GB/Touch/Pen/Office H&S2019/Win10 (2H3Q0PA)", 14490000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai1, 999, "Điện thoại iPhone 12 Pro 512GB", 36990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_airpodspro, 99, "Tai nghe Bluetooth AirPods Pro Wireless Charge Apple MWP22", 5490000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai3, 999, "Điện thoại Realme C15", 15000000, (float) 5));
        hint_products.add(new Product(R.drawable.dongho, 999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, (float) 5));
        hint_products.add(new Product(R.drawable.img_laptopacernitro, 999, "Laptop Acer Nitro AN515 44 R9JM R5 4600H/8GB/512GB/4GB GTX1650/144Hz/Win10 (NH.Q9MSV.003)", 22990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapad, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_galaxyzfold2, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_ipadpro11, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapads340, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_applewatchs5lte, 99, "Apple Watch S5 LTE 40mm viền thép dây thép bạc", 17592000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_laptophppavilion, 9, "Laptop HP Pavilion x360 dw1016TU i3 1115G4/4GB/256GB/Touch/Pen/Office H&S2019/Win10 (2H3Q0PA)", 14490000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai1, 999, "Điện thoại iPhone 12 Pro 512GB", 36990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_airpodspro, 99, "Tai nghe Bluetooth AirPods Pro Wireless Charge Apple MWP22", 5490000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai3, 999, "Điện thoại Realme C15", 15000000, (float) 5));
        hint_products.add(new Product(R.drawable.dongho, 999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, (float) 5));
        hint_products.add(new Product(R.drawable.img_laptopacernitro, 999, "Laptop Acer Nitro AN515 44 R9JM R5 4600H/8GB/512GB/4GB GTX1650/144Hz/Win10 (NH.Q9MSV.003)", 22990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapad, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_galaxyzfold2, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_ipadpro11, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapads340, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_applewatchs5lte, 99, "Apple Watch S5 LTE 40mm viền thép dây thép bạc", 17592000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_laptophppavilion, 9, "Laptop HP Pavilion x360 dw1016TU i3 1115G4/4GB/256GB/Touch/Pen/Office H&S2019/Win10 (2H3Q0PA)", 14490000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai1, 999, "Điện thoại iPhone 12 Pro 512GB", 36990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_airpodspro, 99, "Tai nghe Bluetooth AirPods Pro Wireless Charge Apple MWP22", 5490000, (float) 4.5));
        hint_products.add(new Product(R.drawable.dienthoai3, 999, "Điện thoại Realme C15", 15000000, (float) 5));
        hint_products.add(new Product(R.drawable.dongho, 999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, (float) 5));
        hint_products.add(new Product(R.drawable.img_laptopacernitro, 999, "Laptop Acer Nitro AN515 44 R9JM R5 4600H/8GB/512GB/4GB GTX1650/144Hz/Win10 (NH.Q9MSV.003)", 22990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapad, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_galaxyzfold2, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, (float) 4.5));
        hint_products.add(new Product(R.drawable.img_ipadpro11, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, (float) 4.5));
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
