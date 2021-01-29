package com.example.ecngv2.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.ProductShop;
import com.example.ecngv2.R;

import java.util.List;

public class RCV_ProductShop_Adapter extends RecyclerView.Adapter<RCV_ProductShop_Adapter.ViewHolder> {

    Context context;
    List<ProductShop> list;

    public RCV_ProductShop_Adapter(Context context, List<ProductShop> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_product_shop, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductShop productShop = list.get(position);
        holder.img.setImageResource(productShop.getImg());
        holder.name.setText(productShop.getName());
        holder.price1.setText(productShop.getPrice1());
        holder.price2.setText(productShop.getPrice2());
        holder.price1.setPaintFlags(holder.price1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name, price1, price2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.product_shop_img);
            name = itemView.findViewById(R.id.product_shop_name);
            price1 = itemView.findViewById(R.id.product_shop_price1);
            price2 = itemView.findViewById(R.id.product_shop_price2);
        }
    }
}
