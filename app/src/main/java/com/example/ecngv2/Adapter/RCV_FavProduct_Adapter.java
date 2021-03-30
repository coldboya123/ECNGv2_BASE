package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.FavProduct;
import com.example.ecngv2.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class RCV_FavProduct_Adapter extends RecyclerView.Adapter<RCV_FavProduct_Adapter.ViewHolder> {

    Context context;
    List<FavProduct> list;

    public RCV_FavProduct_Adapter(Context context, List<FavProduct> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_favproduct,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FavProduct favProduct = list.get(position);
        holder.shopimg.setImageResource(favProduct.getShopimg());
        holder.shopname.setText(favProduct.getShopname());
        holder.productimg.setImageResource(favProduct.getImg());
        holder.productname.setText(favProduct.getName());
        holder.productprice.setText(String.format("%,d", favProduct.getPrice())+" đ");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView shopname, productname, productprice;
        ImageView productimg;
        ShapeableImageView shopimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shopname = itemView.findViewById(R.id.shopname);
            productname = itemView.findViewById(R.id.name);
            productprice = itemView.findViewById(R.id.price);
            productimg = itemView.findViewById(R.id.img);
            shopimg = itemView.findViewById(R.id.avatar);
        }
    }
}
